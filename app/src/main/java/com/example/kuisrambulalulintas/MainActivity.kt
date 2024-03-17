package com.example.kuisrambulalulintas

import android.content.DialogInterface
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.kuisrambulalulintas.databinding.ActivityMainBinding
import com.example.kuisrambulalulintas.service.BackgroundSoundService
import com.example.kuisrambulalulintas.ui.activities.GetNameActivity
import com.example.kuisrambulalulintas.ui.activities.HistoryActivity
import com.example.kuisrambulalulintas.ui.activities.LevelActivity
import com.example.kuisrambulalulintas.ui.activities.MateriActivity
import dagger.hilt.android.AndroidEntryPoint


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
            startActivity(Intent(this, LevelActivity::class.java))
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

        binding.cvExit.setOnClickListener {
            showAlertDialog()
            //startActivity(Intent(this,HistoryActivity::class.java))
        }

    }

    override fun onBackPressed() {
       showAlertDialog()
    }

    private fun showAlertDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Apakah anda yakin akan keluar dari aplikasi ini ?")
            .setCancelable(false)
            .setPositiveButton("Ya",DialogInterface.OnClickListener { _, _ ->
                finish()
            })
            .setNegativeButton("keluar",DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.cancel()
            })

        val alert = dialogBuilder.create()
        alert.setTitle("Keluar")
        alert.show()
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