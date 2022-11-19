package com.example.win16

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        val context = this
        val pb = progressBar
        var progress = 0
        pb.max = 3

        val timer = object : CountDownTimer(3000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                progress = progress+1
                pb.progress = progress
            }

            override fun onFinish() {
                val intent = Intent(context, MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }.start()

    }
}