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
            val idLevel1 = 1
            val question1 = 3
            val tvLevel = "Level 1"
            val tvDescLevel = "Newbie"
            val intent = Intent(this,GetNameActivity::class.java)
            intent.putExtra("idLevel",idLevel1)
            intent.putExtra("question",question1)
            intent.putExtra("level",tvLevel)
            intent.putExtra("desc",tvDescLevel)
            startActivity(intent)
        }

        binding.btnLevel2.setOnClickListener {
            val idLevel2 = 2
            val question2 = 5
            val tvLevel = "Level 2"
            val tvDescLevel = "Continuing"
            val intent = Intent(this,GetNameActivity::class.java)
            intent.putExtra("idLevel",idLevel2)
            intent.putExtra("question",question2)
            intent.putExtra("level",tvLevel)
            intent.putExtra("desc",tvDescLevel)
            startActivity(intent)
        }

        binding.btnLevel3.setOnClickListener {
            val idLevel3 = 3
            val question3 = 7
            val tvLevel = "Level 3"
            val tvDescLevel = "Medium"
            val intent = Intent(this,GetNameActivity::class.java)
            intent.putExtra("idLevel",idLevel3)
            intent.putExtra("question",question3)
            intent.putExtra("level",tvLevel)
            intent.putExtra("desc",tvDescLevel)
            startActivity(intent)
        }

        binding.btnLevel4.setOnClickListener {
            val idLevel4 = 4
            val question4 = 9
            val tvLevel = "Level 4"
            val tvDescLevel = "Pro"
            val intent = Intent(this,GetNameActivity::class.java)
            intent.putExtra("idLevel",idLevel4)
            intent.putExtra("question",question4)
            intent.putExtra("level",tvLevel)
            intent.putExtra("desc",tvDescLevel)
            startActivity(intent)
        }

        binding.btnLevel5.setOnClickListener {
            val idLevel5 = 5
            val question5 = 11
            val tvLevel = "Level 5"
            val tvDescLevel = "Legend"
            val intent = Intent(this,GetNameActivity::class.java)
            intent.putExtra("idLevel",idLevel5)
            intent.putExtra("question",question5)
            intent.putExtra("level",tvLevel)
            intent.putExtra("desc",tvDescLevel)
            startActivity(intent)
        }

    }
}