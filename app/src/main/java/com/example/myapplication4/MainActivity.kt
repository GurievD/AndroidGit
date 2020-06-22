package com.example.myapplication4

import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    var editText2: EditText? = null
    var editText3: EditText? = null
    var editText4: EditText? = null

    var textView: TextView? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        editText3 = findViewById(R.id.editText3)
        editText4 = findViewById(R.id.editText4)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
    }

    fun initializeListeners() {
        button?.setOnClickListener {
            val regex: Boolean = editText2!!.text.matches("^((?=.*\\d)(?=.*[a-zA-Z]).{4,})(@[a-zA-Z]{2,})(\\.[a-zA-Z]{2})$".toRegex())
            //Я хорошо изучил regex на курсе Python, поэтому написал регулярку посложнее. Это имитация настоящего почтового адреса.

            //Должно быть минимум 4 символа до "собачки", среди них должна быть минимум одна цифра и буква.
            //После - обязательно должна быть "собачка", и минимум 2 символа перед точкой.
            //После точки - домен, обязательно должны идти ровно две буквы.
            if (editText!!.text.isNotBlank() && editText2!!.text.isNotBlank()) {
                if (!regex && editText2!!.text.isNotBlank()) {
                    textView?.setText(R.string.editText_incorrectEmail)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                } else if (editText3!!.text.isBlank() && editText4!!.text.isBlank() && regex) {
                    textView?.setText(R.string.editText_emptyPasswordFields)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                } else if (editText3?.text.toString() == editText4?.text.toString() && regex) {
                    textView?.setText(R.string.editText_passwordMatch)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorGreen))
                } else if (editText3?.text.toString() != editText4?.text.toString() && regex) {
                    textView?.setText(R.string.editText_passwordNotMatch)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                }
            }
            else {
                if (editText!!.text.isBlank() && editText2!!.text.isBlank()) {
                    textView?.setText(R.string.editText_emptyNameAndEmailFields)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                }
                else if (editText!!.text.isBlank()) {
                    textView?.setText(R.string.editText_emptyNameField)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                }
                else if (editText2!!.text.isBlank()) {
                    textView?.setText(R.string.editText_emptyEmailField)
                    textView?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                }
            }
        }
    }
}