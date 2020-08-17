package com.example.myapplication21.presentaton.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R
import com.example.myapplication21.helpers.classes.Camera
import com.example.myapplication21.helpers.classes.SocialNetwork
import com.example.myapplication21.helpers.classes.SpeechRecognizer
import kotlinx.android.synthetic.main.programs.*

class ProgramsActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.programs)

        initializeListeners()
    }

    fun initializeListeners() {
        button_programs_openSpeechRecognizer.setOnClickListener {
            val intentSpeechRecognizer = Intent(this, SpeechRecognizer::class.java)
            startActivity(intentSpeechRecognizer)
        }
        button_programs_openCamera.setOnClickListener {
            val intentOpenCamera = Intent(this, Camera::class.java)
            startActivity(intentOpenCamera)
        }
        button_programs_openSMS.setOnClickListener {
            val intentOpenSMS = Intent(this, SocialNetwork::class.java)
            startActivity(intentOpenSMS)
        }
    }
}