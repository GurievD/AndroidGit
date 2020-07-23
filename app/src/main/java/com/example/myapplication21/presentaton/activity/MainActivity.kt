package com.example.myapplication21.presentaton.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R
import com.example.myapplication21.leetcode.CheckPalindrome
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        intentOnCreate()
        initializeListeners()
    }

    fun initializeListeners() {
        button_activity_main_goToRecyclerViewList.setOnClickListener {
            intentOnCreate()
        }
        button_leetcode_file_checkPalindrome.setOnClickListener{
            val intentCheckPalindrome = Intent(this, CheckPalindrome::class.java)
            startActivity(intentCheckPalindrome)
        }
    }

    fun intentOnCreate() {
        val intentStudentsActivity = Intent(this, StudentsActivity::class.java)
        startActivity(intentStudentsActivity)
    }
}