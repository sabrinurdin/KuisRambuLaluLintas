package com.example.kuisrambulalulintas.ui.activities

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.databinding.ActivityQuestionBinding
import com.example.kuisrambulalulintas.model.DataSoal
import com.example.kuisrambulalulintas.utils.Constants
import com.example.kuisrambulalulintas.utils.Resource
import com.example.kuisrambulalulintas.viewmodel.MainViewModel
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class QuestionActivity : AppCompatActivity(), SeekBar.OnSeekBarChangeListener {
    private lateinit var binding: ActivityQuestionBinding

    private val viewModel: MainViewModel by viewModels()

    private var userName: String? = null
    private var question: Int? = null
    private var idLevel: Int? = null
    lateinit var timer: CountDownTimer

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
        idLevel = intent.getIntExtra("idLevel", 0)
        question = intent.getIntExtra("question", 0)

        val db = FirebaseFirestore.getInstance()
        val soalRef = db.collection("kuis")

        getDataKuis()

        binding.sbTime.max = 30
        binding.sbTime.progress = 10
        binding.sbTime.setOnSeekBarChangeListener(this)

        timer = object : CountDownTimer((binding.sbTime.progress * 3000).toLong(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                binding.tvTimer.text = "00:0${millisUntilFinished / 1000}"
                val longValue = millisUntilFinished / 1000
                updateSeekbar(longValue.toInt())
            }

            override fun onFinish() {
                //currentQuestionIndex++
                /*updateQuestion()
                Log.d("indexQuestion", "index ${currentQuestionIndex}")*/
                checkAnswer2()


            }

        }
        timer.start()

        tvAlternatives = arrayListOf(
            binding.optionOne,
            binding.optionTwo,
            binding.optionThree,
            binding.optionFour,
        )



        binding.btnSubmit.setOnClickListener {
            var anyQuestion = selectedAlternativeIndex != -1
            if (!anyQuestion){
                Toast.makeText(this,"Silahkan pilih jawaban anda",Toast.LENGTH_SHORT).show()
            } else {
                checkAnswer2()
            }
        }



        tvAlternatives?.let {
            for (optionIndex in it.indices) {
                it[optionIndex].let {
                    it.setOnClickListener {
                        if (!isAnswerChecked) {
                            selectedAlternativeView(it as TextView, optionIndex)
                        }
                    }
                }
            }
        }

    }



    private fun checkAnswer2() {
        Log.d("indexQuestion", "selected ${selectedAlternativeIndex}")

        val anyAnswerIsChecked = selectedAlternativeIndex != -1
        Log.d("indexQuestion", "selectedAlter $selectedAlternativeIndex")
        if (!anyAnswerIsChecked){
            //currentQuestionIndex++
            updateQuestion()
        } else {
            binding.btnSubmit.isEnabled = false
            val currentQuestion = questionsList[currentQuestionIndex]
            if (
                selectedAlternativeIndex == currentQuestion.jawaban
            ) {
                answerView(
                    tvAlternatives!![selectedAlternativeIndex],
                    R.drawable.correct_option_border_bg
                )
                totalScore++
                timer.cancel()
            } else {
                kesalahan++
                timer.cancel()
                answerView(
                    tvAlternatives!![selectedAlternativeIndex],
                    R.drawable.wrong_option_border_bg
                )
                answerView(
                    tvAlternatives!![currentQuestion.jawaban!!],
                    R.drawable.correct_option_border_bg
                )

                Log.d("indexQuestion", "indexQuestion $currentQuestionIndex")

                if (kesalahan == 1) {
                    binding.ivKesempatan1.visibility = View.GONE
                } else if (kesalahan == 2) {
                    binding.ivKesempatan2.visibility = View.GONE
                } else if (kesalahan == 3) {
                    binding.ivKesempatan3.visibility = View.GONE
                } else {

                        if (currentQuestionIndex == question!! - 1) {

                        } else if (currentQuestionIndex > 2) {

                            saveScoreData(idLevel)
                            goToResult()


                        }


                }
            }


            //binding.btnSubmit.text = if (currentQuestionIndex == question!! - 1) "SELESAI" else "SOAL SELANJUTNYA"
            selectedAlternativeIndex = -1

        }

        viewModel.viewModelScope.launch {
            delay(500)
            binding.btnSubmit.isEnabled = true
            updateQuestion()
            if (currentQuestionIndex < question!! - 1) {
                currentQuestionIndex++
                updateQuestion()
                //checkAnswer()
            } else {
                timer.cancel()
                saveScoreData(idLevel)
                goToResult()
            }
        }


    }

    private fun saveScoreData(idLevel: Int?) {
        if (idLevel == 1){
            viewModel.addHistory(userName!!,totalScore)
            //goToResult()
        } else if (idLevel == 2){
            viewModel.addHistory2(userName!!,totalScore)
            //goToResult()
        } else if (idLevel == 3){
            viewModel.addHistory3(userName!!,totalScore)
            // goToResult()
        } else if (idLevel == 4){
            viewModel.addHistory4(userName!!,totalScore)
            //goToResult()
        } else if (idLevel == 5){
            viewModel.addHistory5(userName!!,totalScore)
            //goToResult()
        }
    }

    private fun getDataKuis() {
        viewModel.getKuis()
        viewModel.soal.observe(this) { response ->
            when (response) {
                is Resource.Success -> {
                    questionsList = response.data as ArrayList<DataSoal>
                    questionsList.shuffle()
                    updateQuestion()
                    //binding.progressBar.visibility = View.GONE
                    //binding.linearLayout.visibility = View.VISIBLE
                    Log.d("DataResponse", "$questionsList")
                }

                is Resource.Loading -> {
                    //binding.progressBar2.visibility = View.VISIBLE
                    //binding.linearLayout.visibility = View.GONE
                }

                is Resource.Error -> {
                    //binding.progressBar2.visibility = View.GONE
                }

                else -> {

                }
            }

        }
    }


    private fun updateQuestion() {
        //checkAnswer()

        //viewModel.viewModelScope.launch {

            //delay(500)
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
            binding.progressBar.max = question!!
            binding.progressBar.progress = currentQuestionIndex + 1
            // Text of progress bar
            binding.tvProgress.text = "${currentQuestionIndex + 1}/${question!!}"

            //binding.btnSubmit.isEnabled = false

            for (alternativeIndex in questionsList[currentQuestionIndex].pilihan!!.indices) {
                tvAlternatives!![alternativeIndex].text =
                    questionsList[currentQuestionIndex].pilihan?.get(alternativeIndex)!!
            }

            binding.btnSubmit.text =
                if (currentQuestionIndex == question!! - 1) "SELESAI" else "SOAL SELANJUTNYA"
        //}


        //binding.btnSubmit.text = if (currentQuestionIndex == question!! - 1) "SELESAI" else "JAWAB"
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
    private fun updateSeekbar(progress: Int) {
        val minute: Int = progress / 60
        val seconds: Int = progress % 60
        var secondsFinal = ""
        if (seconds <= 9) {
            secondsFinal = "0" + seconds
        } else {
            secondsFinal = "" + seconds
        }

        binding.sbTime.progress = progress
        binding.tvTimer.text = "$minute:$secondsFinal"
    }

    private fun goToResult(){
        val intent = Intent(applicationContext, ResultActivity::class.java)
        intent.putExtra(Constants.USER_NAME, userName)
        intent.putExtra(Constants.TOTAL_SoalS, question!!)
        intent.putExtra(Constants.SCORE, totalScore)
        startActivity(intent)
        finish()
    }

    override fun onProgressChanged(p0: SeekBar?, progress: Int, p2: Boolean) {
        updateSeekbar(progress)
    }

    override fun onStartTrackingTouch(p0: SeekBar?) {
    }

    override fun onStopTrackingTouch(p0: SeekBar?) {
    }

    override fun onBackPressed() {
        showAlertDialog()

    }

    private fun showAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Apakah anda yakin akan keluar dari permainan ini ?")
            .setCancelable(false)
            .setPositiveButton("Ya", DialogInterface.OnClickListener { _, _ ->
                finish()
            })
            .setNegativeButton("keluar", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Keluar")
        alert.show()
    }



}

/*binding.btnSubmit.setOnClickListener {
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
                    intent.putExtra(Constants.TOTAL_SoalS, question!!)
                    intent.putExtra(Constants.SCORE, totalScore)
                    startActivity(intent)
                    finish()
                }
            }

            isAnswerChecked = true
            binding.btnSubmit.text = if (currentQuestionIndex == question!! - 1) "SELESAI" else "SOAL SELANJUTNYA"
            selectedAlternativeIndex = -1
        }
    } else {
        if (currentQuestionIndex < question!! - 1) {
            currentQuestionIndex++
            updateQuestion()
        } else {
            val intent = Intent(this, ResultActivity::class.java)
            intent.putExtra(Constants.USER_NAME, userName)
            intent.putExtra(Constants.TOTAL_SoalS, question!!)
            intent.putExtra(Constants.SCORE, totalScore)
            startActivity(intent)
            finish()
        }

        isAnswerChecked = false
    }
}*/

/*    private fun checkAnswer() {
        val anyAnswerIsChecked = selectedAlternativeIndex != -1
        Log.d("indexQuestion", "selected ${selectedAlternativeIndex}")
        Log.d("indexQuestion", "indexQuestion $currentQuestionIndex")
        if (!anyAnswerIsChecked) {
            currentQuestionIndex++
            updateQuestion()
        } else {
            binding.btnSubmit.isEnabled = false
            val currentQuestion = questionsList[currentQuestionIndex]

            if (
                selectedAlternativeIndex == currentQuestion.jawaban
            ) {
                answerView(
                    tvAlternatives!![selectedAlternativeIndex],
                    R.drawable.correct_option_border_bg
                )
                totalScore++
                timer.cancel()
                //updateQuestion()
            } else {
                //updateQuestion()
                kesalahan++
                timer.cancel()
                answerView(
                    tvAlternatives!![selectedAlternativeIndex],
                    R.drawable.wrong_option_border_bg
                )
                answerView(
                    tvAlternatives!![currentQuestion.jawaban!!],
                    R.drawable.correct_option_border_bg
                )

                if (kesalahan == 1) {
                    binding.ivKesempatan1.visibility = View.GONE
                } else if (kesalahan == 2) {
                    binding.ivKesempatan2.visibility = View.GONE
                } else if (kesalahan == 3) {
                    binding.ivKesempatan3.visibility = View.GONE
                } else {

                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra(Constants.USER_NAME, userName)
                    intent.putExtra(Constants.TOTAL_SoalS, question!!)
                    intent.putExtra(Constants.SCORE, totalScore)
                    startActivity(intent)
                    finish()
                }
            }



            if (currentQuestionIndex < question!! - 1) {
                currentQuestionIndex++
                updateQuestion()
                //checkAnswer()
            } else {
                timer.cancel()
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.USER_NAME, userName)
                intent.putExtra(Constants.TOTAL_SoalS, question!!)
                intent.putExtra(Constants.SCORE, totalScore)
                startActivity(intent)
                finish()
            }

            isAnswerChecked = true
            //binding.btnSubmit.text = if (currentQuestionIndex == question!! - 1) "SELESAI" else "SOAL SELANJUTNYA"
            selectedAlternativeIndex = -1
        }
        //} else {
        *//*    if (currentQuestionIndex < question!! - 1) {
                currentQuestionIndex++
                updateQuestion()
            } else {
                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(Constants.USER_NAME, userName)
                intent.putExtra(Constants.TOTAL_SoalS, question!!)
                intent.putExtra(Constants.SCORE, totalScore)
                startActivity(intent)
                finish()
            }*//*

        isAnswerChecked = false
        //}
    }*/

