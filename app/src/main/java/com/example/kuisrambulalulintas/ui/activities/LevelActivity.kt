package com.example.kuisrambulalulintas.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.databinding.ActivityLevelBinding

class LevelActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLevelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLevelBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.clLevel1.setOnClickListener {
            startActivity(Intent(this,QuestionActivity::class.java))
        }

        binding.btnLevel2.setOnClickListener {
            startActivity(Intent(this,QuestionActivity::class.java))
        }
    }
}