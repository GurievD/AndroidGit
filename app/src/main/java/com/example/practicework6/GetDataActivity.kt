package com.example.practicework6

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GetDataActivity : AppCompatActivity() {
    var textViewToShowData: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_data)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        textViewToShowData = findViewById(R.id.textView_activity_main_showData)
    }
    fun initializeListeners() {
        val getData = intent.getStringExtra("data")
        textViewToShowData?.text = getString(R.string.get_data_textView_showData, getData)
    }
}