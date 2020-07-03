package com.example.myapplication16

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var editTextToInputName: EditText? = null
    var editTextToInputEmail: EditText? = null
    var editTextToInputLogin: EditText? = null
    var editTextToInputPassword: EditText? = null

    var buttonGoToSecondActivity: Button? = null
    var textViewToShowError: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        editTextToInputName = findViewById(R.id.editText_activity_main_name)
        editTextToInputEmail = findViewById(R.id.editText_activity_main_email)
        editTextToInputLogin = findViewById(R.id.editText_activity_main_login)
        editTextToInputPassword = findViewById(R.id.editText_activity_main_password)

        buttonGoToSecondActivity = findViewById(R.id.button_activity_main_intentAction)
        textViewToShowError = findViewById(R.id.textView_activity_main_invalidData)
    }



    fun initializeListeners() {
        buttonGoToSecondActivity?.setOnClickListener {
            val intentGetDataActivity = Intent(this, GetDataActivity::class.java)
            //В прошлый раз regex был не завершён, выражение пропускало больше одного символа собачки (@), заметил только когда взялся за это задание. Я всё исправил.
            val regexMatches: Boolean = editTextToInputEmail!!.text.matches("^((?=.*\\d)(?!.*[\\\\+$=()*?&:;^%#!\\[\\]{}<>,/|`~'№])(?=[a-zA-Z])[^@]{4,})([@][a-zA-Z]{2,})(\\.[a-zA-Z]{2})$".toRegex())

            if (editTextToInputName!!.text.isNotBlank() && editTextToInputEmail!!.text.isNotBlank() && editTextToInputLogin!!.text.isNotBlank() && editTextToInputPassword!!.text.isNotBlank() && regexMatches) {
                textViewToShowError?.text = null
                intentGetDataActivity.putExtra("name", editTextToInputName?.text.toString())
                intentGetDataActivity.putExtra("email", editTextToInputEmail?.text.toString())
                intentGetDataActivity.putExtra("login", editTextToInputLogin?.text.toString())
                intentGetDataActivity.putExtra("password", editTextToInputPassword?.text.toString())

                startActivity(intentGetDataActivity)
            }
            else if (editTextToInputName!!.text.isNotBlank() && editTextToInputEmail!!.text.isNotBlank() && editTextToInputLogin!!.text.isNotBlank() && editTextToInputPassword!!.text.isNotBlank() && !regexMatches)
            {
                textViewToShowError?.text = resources.getText(R.string.activity_main_textView_invalidEmail)
                textViewToShowError?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
            }
            else {
                textViewToShowError?.text = resources.getText(R.string.activity_main_textView_emptyFieldError)
                textViewToShowError?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
            }
        }
    }
}

