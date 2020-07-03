package com.example.myapplication16

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GetDataActivity : AppCompatActivity() {
    var textViewToShowName: TextView? = null
    var textViewToShowEmail: TextView? = null
    var textViewToShowLogin: TextView? = null
    var textViewToShowPassword: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_data)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        textViewToShowName = findViewById(R.id.textView_activity_main_showName)
        textViewToShowEmail = findViewById(R.id.textView_activity_main_showEmail)
        textViewToShowLogin = findViewById(R.id.textView_activity_main_showLogin)
        textViewToShowPassword = findViewById(R.id.textView_activity_main_showPassword)
    }

    fun initializeListeners() {
        val getName = intent.getStringExtra("name")
        val getEmail = intent.getStringExtra("email")
        val getLogin = intent.getStringExtra("login")
        val getPassword = intent.getStringExtra("password")

        textViewToShowName?.text = getString(R.string.get_data_textView_Name, getName)
        textViewToShowEmail?.text = getString(R.string.get_data_textView_Email, getEmail)
        textViewToShowLogin?.text = getString(R.string.get_data_textView_Login, getLogin)
        textViewToShowPassword?.text = getString(R.string.get_data_textView_Password, getPassword)
    }

}