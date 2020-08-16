package com.example.myapplication21.presentaton.fragment

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.myapplication21.R
import com.example.myapplication21.di.component.DaggerContextComponent
import com.example.myapplication21.di.module.ContextModule
import com.example.myapplication21.domain.usecase.function.context.MyContext

import com.example.myapplication21.leetcode.CheckPalindrome
import com.example.myapplication21.presentaton.activity.NotesActivity
import com.example.myapplication21.presentaton.activity.ProgramsActivity
import com.example.myapplication21.presentaton.activity.StudentsActivity
import kotlinx.android.synthetic.main.camera.*
import kotlinx.android.synthetic.main.fragment_mainpage.*
import javax.inject.Inject

class MainPageFragment : BaseFragment() {
    var imageURI: Uri? = null
    @Inject
    lateinit var myContext: MyContext

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_mainpage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerContextComponent.builder().contextModule(ContextModule(this)).build().injectMainPageFragment(this)


        initializeListeners()
    }

    override fun onClick(view: View?) {
        when(view?.id) {
            R.id.button_activity_main_goToRecyclerViewList -> {
                val intentStudentsActivity = Intent(myContext.returnContext(context!!), StudentsActivity::class.java)
                startActivity(intentStudentsActivity)
            }
            R.id.button_activity_main_openLeetCode -> {
                val intentCheckPalindrome = Intent(myContext.returnContext(context!!), CheckPalindrome::class.java)
                startActivity(intentCheckPalindrome)
            }
            R.id.button_activity_main_programs -> {
                val intentSpeechRecognizer = Intent(myContext.returnContext(context!!), ProgramsActivity::class.java)
                startActivity(intentSpeechRecognizer)
            }
            R.id.button_activity_main_goToNoteList -> {
                val intentNotesActivity = Intent(myContext.returnContext(context!!), NotesActivity::class.java)
                startActivity(intentNotesActivity)
                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
                    Toast.makeText(myContext.returnContext(context!!), "Увы, для работы нужен Oreo (API 26) :(\nСкачайте его!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode  == Activity.RESULT_OK) {
            imageView_camera_showCapturedPhoto.setImageURI(imageURI)

        }
    }

    fun initializeListeners() {
        button_activity_main_goToRecyclerViewList.setOnClickListener(this)
        button_activity_main_openLeetCode.setOnClickListener(this)
        button_activity_main_programs.setOnClickListener(this)
        button_activity_main_goToNoteList.setOnClickListener(this)
    }
}