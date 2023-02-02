package com.example.kuisrambulalulintas.ui.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.kuisrambulalulintas.R
import com.example.kuisrambulalulintas.databinding.ActivityGetNameBinding
import com.example.kuisrambulalulintas.utils.Constants

class GetNameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGetNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idLevel = intent.getIntExtra("idLevel", 0)
        val question = intent.getIntExtra("question", 0)
        val level = intent.getStringExtra("level")
        val desc = intent.getStringExtra("desc")

        binding.tvLevel.text = level
        binding.tvDesLevel.text = desc

        if (idLevel == 1) {
            binding.clBackground.setBackgroundResource(R.drawable.bg_button)
            binding.btnStart.setBackgroundResource(R.drawable.bg_button)
        } else if (idLevel == 2) {
            binding.clBackground.setBackgroundResource(R.drawable.bg_level2)
            binding.btnStart.setBackgroundResource(R.drawable.bg_level2)
        } else if (idLevel == 3) {
            binding.clBackground.setBackgroundResource(R.drawable.bg_level3)
            binding.btnStart.setBackgroundResource(R.drawable.bg_level3)
        } else if (idLevel == 4) {
            binding.clBackground.setBackgroundResource(R.drawable.bg_level4)
            binding.btnStart.setBackgroundResource(R.drawable.bg_level4)
        } else {
            binding.clBackground.setBackgroundResource(R.drawable.bg_level5)
            binding.btnStart.setBackgroundResource(R.drawable.bg_level5)
        }

        binding.btnStart.setOnClickListener {
            if (binding.etName.text!!.isEmpty()) {
                Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                intent.putExtra("question", question)
                startActivity(intent)
//                finish()
            }
        }
    }
}