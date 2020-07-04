package com.example.practicework4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var buttonToCallPhoneNumber: Button? = null
    var buttonToTurnOnCamera: Button? = null
    //Извиняюсь, забыл запушить в git, и залить некоторые практические работы в MyStat, которые я сделал
    //Прошу прощения, я не специально!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        buttonToCallPhoneNumber = findViewById(R.id.button_activity_main_actionCall)
        buttonToTurnOnCamera = findViewById(R.id.button_activity_main_actionCamera)
    }
    fun initializeListeners() {
        buttonToCallPhoneNumber?.setOnClickListener {
            val phoneNumber = "+77711949025"
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:$phoneNumber")
            startActivity(callIntent)
        }
        buttonToTurnOnCamera?.setOnClickListener {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(cameraIntent)
        }
    }
}