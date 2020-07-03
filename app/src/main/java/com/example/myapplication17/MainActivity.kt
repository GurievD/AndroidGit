package com.example.myapplication17

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    var editTextToInputName: EditText? = null
    var editTextToInputLastName: EditText? = null
    var imageViewToShowPicture: ImageView? = null

    var buttonGoToSecondActivity: Button? = null
    var textViewToShowError: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
        check()
    }

    fun initializeView() {
        editTextToInputName = findViewById(R.id.editText_activity_main_name)
        editTextToInputLastName = findViewById(R.id.editText_activity_main_lastName)
        imageViewToShowPicture = findViewById(R.id.imageView_activity_main_showPicture)
        buttonGoToSecondActivity = findViewById(R.id.button_activity_main_intentAction)
        textViewToShowError = findViewById(R.id.textView_activity_main_invalidData)
    }



    fun initializeListeners() {
        buttonGoToSecondActivity?.setOnClickListener {
            val intentGetDataActivity = Intent(this, GetDataActivity::class.java)

            if (editTextToInputName!!.text.isNotBlank() && editTextToInputLastName!!.text.isNotBlank()) {
                textViewToShowError?.text = null
                intentGetDataActivity.putExtra("name", editTextToInputName?.text.toString())
                intentGetDataActivity.putExtra("lastname", editTextToInputLastName?.text.toString())
                intentGetDataActivity.putExtra("picture", R.drawable.picture)
                imageViewToShowPicture?.setImageResource(R.drawable.picture)
                startActivity(intentGetDataActivity)
            }
            else {
                check()
                textViewToShowError?.text = resources.getText(R.string.activity_main_textView_emptyFieldError)
                textViewToShowError?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
            }
        }
    }

    fun check() {
        if (editTextToInputName!!.text.isBlank() || editTextToInputLastName!!.text.isBlank()) {
            imageViewToShowPicture?.setImageResource(R.drawable.picture2)
        }
    }
}