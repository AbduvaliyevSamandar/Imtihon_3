package com.example.imtihon3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.imtihon3.databinding.ActivitySplashBinding

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)




        object :CountDownTimer(3000,1000){
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                val intent=Intent(this@SplashActivity,MainActivity::class.java)
                startActivity(intent)
                finish()
            }

        }.start()

    }
}