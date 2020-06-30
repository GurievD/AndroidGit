package com.example.myapplication13

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.os.Build.*
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var textViewToShowAPIVersion: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initiailizeView()
        initializeListeners()
    }

    fun initiailizeView() {
        textViewToShowAPIVersion = findViewById(R.id.textView_activity_main_show_API_version)

    }
    fun initializeListeners() {
        if (VERSION.SDK_INT >= VERSION_CODES.LOLLIPOP_MR1) {
            //Не нашёл как получить имя, поэтому написал свой when
            val showName = when(VERSION.SDK_INT) {
                22 -> "Lollipop"
                23 -> "Marshmallow"
                24, 25 -> "Nougat"
                26, 27 -> "Oreo"
                28 -> "Pie"
                29 -> "Q"
                30 -> "R"
                else -> ""
            }
            textViewToShowAPIVersion?.text = getString(R.string.activity_main_textView_show_API_version, VERSION.SDK_INT.toString(), showName, VERSION.RELEASE)
            textViewToShowAPIVersion?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorGreen))
        }

    }
}