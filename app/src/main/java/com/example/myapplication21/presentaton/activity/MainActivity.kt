package com.example.myapplication21.presentaton.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeListeners()
    }

    fun initializeListeners() {
        val intentStudentsActivity = Intent(this, StudentsActivity::class.java)
        startActivity(intentStudentsActivity)
    }
}