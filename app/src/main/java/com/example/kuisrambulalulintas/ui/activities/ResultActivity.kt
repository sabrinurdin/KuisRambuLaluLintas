package com.example.kuisrambulalulintas.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kuisrambulalulintas.MainActivity
import com.example.kuisrambulalulintas.databinding.ActivityResultBinding
import com.example.kuisrambulalulintas.utils.Constants

class ResultActivity : AppCompatActivity() {

    private lateinit var binding : ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userName = intent.getStringExtra(Constants.USER_NAME)
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_SoalS, 0)
        val score = intent.getIntExtra(Constants.SCORE, 0)
        binding.congratulationsTv.text = "Hai, $userName!"
        binding.scoreTv.text = "Kamu jawab benar $score dari $totalQuestions soal"
        binding.tvHasil.text = "$score/$totalQuestions"
        binding.progressBar2.progress = score
        binding.progressBar2.max = totalQuestions
        binding.btnRestart.setOnClickListener{
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("question",totalQuestions)
            intent.putExtra(Constants.USER_NAME,userName)
            startActivity(intent)
            finish()
        }

        binding.btnMenu.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}