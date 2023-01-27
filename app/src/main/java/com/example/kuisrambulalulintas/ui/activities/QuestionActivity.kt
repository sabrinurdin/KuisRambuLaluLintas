package com.example.kuisrambulalulintas.ui.activities

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.databinding.ActivityQuestionBinding
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.model.Soal
import com.example.kuisrambulalulintas.utils.Constants
import com.example.kuisrambulalulintas.utils.Resource
import com.example.kuisrambulalulintas.viewmodel.MainViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class QuestionActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var binding : ActivityQuestionBinding

    private val viewModel : MainViewModel by viewModels()

    private var userName: String? = null
    private lateinit var timer: CountDownTimer

    private var questionsList: ArrayList<DataSoal> = ArrayList()

    private var currentQuestionIndex = 0
    private var selectedAlternativeIndex = -1
    private var isAnswerChecked = false;
    private var totalScore = 0;
    private var kesalahan = 0;
    private val alternativesIds = arrayOf(
        R.id.optionOne,
        R.id.optionTwo,
        R.id.optionThree,
        R.id.optionFour
    )

    private var tvAlternatives: ArrayList<TextView>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuestionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userName = intent.getStringExtra(Constants.USER_NAME)

        val db = FirebaseFirestore.getInstance()
        val soalRef = db.collection("kuis")

        getDataKuis()

        binding.sbTime.max = 10
        binding.sbTime.progress = 10
        binding.sbTime.setOnSeekBarChangeListener(this)

        timer = object : CountDownTimer((binding.sbTime.progress * 1000).toLong(),1000){
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = "00:0${millisUntilFinished / 1000}"
                val longValue = millisUntilFinished / 1000
                updateSeekbar(longValue.toInt())
            }

            override fun onFinish() {
                if (currentQuestionIndex < questionsList.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                } else {
                    val intent = Intent(this@QuestionActivity, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    intent.putExtra(Constants.TOTAL_SoalS, questionsList.size)
                    intent.putExtra(Constants.SCORE, totalScore)
                    startActivity(intent)
                    finish()
                }
            }

        }
        timer.start()

        tvAlternatives = arrayListOf(
            binding.optionOne,
            binding.optionTwo,
            binding.optionThree,
            binding.optionFour,
        )

        //updateQuestion()

        binding.btnSubmit.setOnClickListener {
            if (!isAnswerChecked) {
                val anyAnswerIsChecked = selectedAlternativeIndex != -1
                if (!anyAnswerIsChecked) {
                    Toast.makeText(this, "Please, pilih jawaban anda", Toast.LENGTH_SHORT).show()
                } else {
                    val currentQuestion = questionsList[currentQuestionIndex]
                    if (
                        selectedAlternativeIndex == currentQuestion.jawaban
                    ) {
                        answerView(tvAlternatives!![selectedAlternativeIndex],
                            R.drawable.correct_option_border_bg
                        )
                        totalScore++
                        timer.cancel()
                    } else {
                        kesalahan++
                        timer.cancel()
                        answerView(tvAlternatives!![selectedAlternativeIndex],
                            R.drawable.wrong_option_border_bg
                        )
                        answerView(tvAlternatives!![currentQuestion.jawaban!!],
                            R.drawable.correct_option_border_bg
                        )

                        if (kesalahan == 1){
                            binding.ivKesempatan1.visibility = View.GONE
                        } else if (kesalahan == 2){
                            binding.ivKesempatan2.visibility = View.GONE
                        } else if (kesalahan == 3){
                            binding.ivKesempatan3.visibility = View.GONE
                        }else {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, userName)
                            intent.putExtra(Constants.TOTAL_SoalS, questionsList.size)
                            intent.putExtra(Constants.SCORE, totalScore)
                            startActivity(intent)
                            finish()
                        }
                    }

                    isAnswerChecked = true
                    binding.btnSubmit.text = if (currentQuestionIndex == questionsList.size - 1) "SELESAI" else "SOAL SELANJUTNYA"
                    selectedAlternativeIndex = -1
                }
            } else {
                if (currentQuestionIndex < questionsList.size - 1) {
                    currentQuestionIndex++
                    updateQuestion()
                } else {
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    intent.putExtra(Constants.TOTAL_SoalS, questionsList.size)
                    intent.putExtra(Constants.SCORE, totalScore)
                    startActivity(intent)
                    finish()
                }

                isAnswerChecked = false
            }
        }

        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].let {
                    it.setOnClickListener{
                        if (!isAnswerChecked) {
                            selectedAlternativeView(it as TextView, optionIndex)
                        }
                    }
                }
            }
        }

    }

    private fun getDataKuis() {
        viewModel.getKuis()
        viewModel.soal.observe(this){ response ->
            when(response){
                is Resource.Success -> {
                    questionsList = response.data as ArrayList<DataSoal>
                    updateQuestion()

                    Log.d("DataResponse","$questionsList")
                }

                is Resource.Loading -> {

                }
                is Resource.Error -> {

                }
                else -> {

                }
            }

        }
    }


    private fun updateQuestion() {
        defaultAlternativesView()
        timer.start()

        // Render Question Text
        binding.tvQuestion.text = "Apa arti gambar lalu lintas di bawah ini"
        // Render Question Image
        Glide.with(applicationContext)
            .load(questionsList[currentQuestionIndex].image)
            .into(binding.ivImage)
        // progressBar
        //binding.ivImage.setIma(questionsList[currentQuestionIndex].image)
        binding.progressBar.progress = currentQuestionIndex + 1
        // Text of progress bar
        binding.tvProgress.text = "${currentQuestionIndex + 1}/${questionsList.size}"

        for (alternativeIndex in questionsList[currentQuestionIndex].pilihan!!.indices) {
            tvAlternatives!![alternativeIndex].text = questionsList[currentQuestionIndex].pilihan?.get(alternativeIndex)!!
        }

        binding.btnSubmit.text = if (currentQuestionIndex == questionsList.size - 1) "SELESAI" else "JAWAB"
    }

    private fun defaultAlternativesView() {
        for (alternativeTv in tvAlternatives!!) {
            alternativeTv.typeface = Typeface.DEFAULT
            alternativeTv.setTextColor(Color.parseColor("#7A8089"))
            alternativeTv.background = ContextCompat.getDrawable(
                this@QuestionActivity,
                R.drawable.default_option_border_bg
            )
        }
    }

    private fun selectedAlternativeView(option: TextView, index: Int) {
        defaultAlternativesView()
        selectedAlternativeIndex = index

        option.setTextColor(
            Color.parseColor("#363A43")
        )
        option.setTypeface(option.typeface, Typeface.BOLD)
        option.background = ContextCompat.getDrawable(
            this@QuestionActivity,
            R.drawable.selected_option_border_bg
        )
    }

    private fun answerView(view: TextView, drawableId: Int) {
        view.background = ContextCompat.getDrawable(
            this@QuestionActivity,
            drawableId
        )
        tvAlternatives!![selectedAlternativeIndex].setTextColor(
            Color.parseColor("#FFFFFF")
        )
    }

    @SuppressLint("SetTextI18n")
    private fun updateSeekbar(progress: Int){
        val minute : Int = progress / 60
        val seconds : Int = progress % 60
        var secondsFinal = ""
        if (seconds <= 9){
            secondsFinal = "0"  +seconds
        } else {
            secondsFinal = "" + seconds
        }

        binding.sbTime.progress = progress
        binding.tvTimer.text = "$minute:$secondsFinal"
    }

    override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
        updateSeekbar(progress)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }
}