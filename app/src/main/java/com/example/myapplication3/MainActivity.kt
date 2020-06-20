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
            val nonNumeric: Boolean = editText!!.text.matches("[^\\\\0-9]+".toRegex())

            Log.i("TAG", "SET MSG")

            if (editText!!.text.isNotBlank()) {

                if (nonNumeric) {
                    textView?.setText(R.string.everything_fine)
                } else if (!nonNumeric) {
                    textView?.setText(R.string.error_we_have_digits)
                }
            }
            else if (editText!!.text.isBlank()) {
                textView?.setText(R.string.blank)
            }

        }
    }
}




