package com.example.kuisrambulalulintas

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kuisrambulalulintas.databinding.ActivityMainBinding
import com.example.kuisrambulalulintas.service.BackgroundSoundService
import com.example.kuisrambulalulintas.ui.activities.GetNameActivity
import com.example.kuisrambulalulintas.ui.activities.MateriActivity

class MainActivity : AppCompatActivity() {

    var mediaPlayer: MediaPlayer? = null
    var status: Int? = 0

    lateinit var sharedPref : SharedPreferences

    var mPlay = false

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor = sharedPref.edit()

        //startService(Intent(this, BackgroundSoundService::class.java))


        binding.cvPlay.setOnClickListener {
            startActivity(Intent(this, GetNameActivity::class.java))
        }

        binding.cvMusic.setOnClickListener {
            if (mPlay){
                mPlay = false
                status = 1
                editor.apply {
                    putInt("status", status!!)
                }
                val statusOFF = sharedPref.getInt("status",status!!)
                status = statusOFF
                binding.tvMusic.text = "MUSIC : OFF"
                stopService(Intent(this, BackgroundSoundService::class.java))
            } else {
                mPlay = true
                status = 0
                editor.apply {
                    putInt("status", status!!)
                }
                val statusOFF = sharedPref.getInt("status",status!!)
                status = statusOFF
                binding.tvMusic.text = "MUSIC : ON"
                startService(Intent(this, BackgroundSoundService::class.java))
            }
        }

        binding.cvMateri.setOnClickListener {
            startActivity(Intent(this,MateriActivity::class.java))

        }

    }


    /*private fun playAudio() {
       if (mediaPlayer == null){
           mediaPlayer = MediaPlayer.create(this,R.raw.music)
           mediaPlayer!!.isLooping = true
           mediaPlayer!!.start()
       } else {
           mediaPlayer!!.start()
       }
    }*/
}