package com.example.myapplication6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var editText: EditText? = null
    var editText2: EditText? = null
    var textView: TextView? = null
    var button: Button? = null
    var button2: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        editText = findViewById(R.id.editText)
        editText2 = findViewById(R.id.editText2)
        button = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)


        textView = findViewById(R.id.textView)

    }
    fun initializeListeners() {
        val LOGIN_ICARUS = "icarus"
        val PASSWORD_FALLEN = "fallen"

        button!!.setOnClickListener {
            if (editText!!.text.toString() == LOGIN_ICARUS && editText2!!.text.toString() == PASSWORD_FALLEN)
            {
                textView?.setText(R.string.edit_so_sad)
            }
            else {
                textView?.setText(R.string.edit_kotlin)
            }
        }
        button2!!.setOnClickListener {
            if (editText?.visibility == View.VISIBLE) {
                editText?.visibility = View.INVISIBLE
                editText2?.visibility = View.INVISIBLE
                textView?.visibility = View.INVISIBLE
                button?.visibility = View.INVISIBLE

            }
            else if (editText?.visibility == View.INVISIBLE) {
                editText?.visibility = View.VISIBLE
                editText2?.visibility = View.VISIBLE
                textView?.visibility = View.VISIBLE
                button?.visibility = View.VISIBLE
            }
        }

    }
}