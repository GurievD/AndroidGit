package com.example.myapplication21.presentaton.activity

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R
import com.example.myapplication21.leetcode.CheckPalindrome
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.camera.*


class MainActivity : AppCompatActivity() {
    var imageURI: Uri? = null
    var contentValues: ContentValues? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        contentValues = ContentValues()
    }

    fun initializeListeners() {
        button_activity_main_goToRecyclerViewList.setOnClickListener {
            val intentStudentsActivity = Intent(this, StudentsActivity::class.java)
            startActivity(intentStudentsActivity)
        }
        button_activity_main_openLeetCode.setOnClickListener{
            val intentCheckPalindrome = Intent(this, CheckPalindrome::class.java)
            startActivity(intentCheckPalindrome)
        }
        button_activity_main_programs.setOnClickListener {
            val intentSpeechRecognizer = Intent(this, ProgramsActivity::class.java)
            startActivity(intentSpeechRecognizer)
        }
        button_activity_main_goToNoteList.setOnClickListener {
            val intentNotesActivity = Intent(this, NotesActivity::class.java)
            startActivity(intentNotesActivity)
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                Toast.makeText(this, "Увы, для работы нужен Oreo (API 26) :(\nСкачайте его!", Toast.LENGTH_LONG).show()
            }

        }
    }

    fun intentOnCreate() {
        val intentNotesActivity = Intent(this, NotesActivity::class.java)
        startActivity(intentNotesActivity)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode  == Activity.RESULT_OK) {
            imageView_camera_showCapturedPhoto.setImageURI(imageURI)

        }
    }
}