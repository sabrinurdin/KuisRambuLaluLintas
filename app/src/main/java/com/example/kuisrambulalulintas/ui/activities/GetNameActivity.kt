package com.example.kuisrambulalulintas.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kuisrambulalulintas.databinding.ActivityGetNameBinding
import com.example.kuisrambulalulintas.utils.Constants

class GetNameActivity : AppCompatActivity() {

    private lateinit var binding : ActivityGetNameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGetNameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            if (binding.etName.text!!.isEmpty()) {
                Toast.makeText(this, "Please, enter your name", Toast.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, QuestionActivity::class.java)
                intent.putExtra(Constants.USER_NAME, binding.etName.text.toString())
                startActivity(intent)
//                finish()
            }
        }
    }
}