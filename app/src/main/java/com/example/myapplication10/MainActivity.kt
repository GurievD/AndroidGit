package com.example.myapplication10

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var buttonGoToSecondPage: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        buttonGoToSecondPage = findViewById(R.id.button_activity_main_send_to_Whatsapp)
    }

    fun initializeListeners() {
        //Как я понял, почитав статьи, SmsManager - может сразу отослать сообщение, но Intent - может только отослать нас на страницу мессенджера
        //где мы уже сами вручную должны нажать на кнопку отправки сообщения, + ещё можем отредактировать наше сообщение
        //Либо же я где-то что-то неправильно сделал или неправильно понял..
        buttonGoToSecondPage?.setOnClickListener {
            val phoneNumber = "+77711949025"
            val smsText = "Hello i have written Intent which sending you this message"
            val intentSendsToSecondPage = Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", phoneNumber, null))
            intentSendsToSecondPage.putExtra("sms_body", smsText)
            startActivity(intentSendsToSecondPage)
        }
    }
}