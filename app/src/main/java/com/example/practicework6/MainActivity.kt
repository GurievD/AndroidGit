package com.example.practicework6

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var buttonGoToSecondActivity: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        buttonGoToSecondActivity = findViewById(R.id.button_activity_main_intentAction)
    }
    fun initializeListeners() {
        buttonGoToSecondActivity?.setOnClickListener {
            val intentGetDataActivity = Intent(this, GetDataActivity::class.java)
            intentGetDataActivity.putExtra("data", "Это текст из первой Activity")
            startActivity(intentGetDataActivity)
        }
    }
}