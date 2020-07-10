package com.example.myapplication19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var buttonGoToFragments: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        initializeViews()
        initializeListeners()
    }

    fun initializeViews(){
        buttonGoToFragments = findViewById(R.id.button_activity_main_goToFragmentsAction)
    }

    fun initializeListeners(){
        buttonGoToFragments?.setOnClickListener {
            val intentFragmentsPage = Intent(this, StudentsActivity::class.java)
            startActivity(intentFragmentsPage)
        }
    }
}