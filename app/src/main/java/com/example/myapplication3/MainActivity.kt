package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var button: Button? = null
    var textView: TextView? = null
    var editText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        button = findViewById(R.id.action)
        textView = findViewById(R.id.textView2)
        editText = findViewById(R.id.editor)
    }

    fun initializeListeners() {
        button?.setOnClickListener {
            val numeric: Boolean = editText!!.text.matches("[A-Za-z ]+".toRegex())
            Log.i("TAG", "SET MSG")
            if (numeric) {
                textView?.setText(R.string.everything_fine)
            }
            else {
                !numeric
                textView?.setText(R.string.error_we_have_digits)

            }
        }
    }
}




