package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.presentaton.base.BaseContract
import kotlinx.android.synthetic.main.activity_registration.*

class StudentsInformationFragment: Fragment(), BaseContract.BaseView {
    var rootView: View? = null
    var student: Student? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.activity_registration,
            container,
            false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
    }

    override fun initializeViews() {
        student = arguments?.getParcelable("studObject")

        textView_activity_registration_showNameAndLastName.text = "${student?.studentName} ${student?.studentLastName}"
        textView_activity_registration_showDescription.text = "${student?.studentDescription}"
        textView_activity_registration_showGroup.text = "${student?.studentGroup}-й класс"
        imageView_activity_registration_showImage.setImageBitmap(student?.avatar)
        textView_activity_registration_showMark.text = "Средняя оценка: ${student?.studentMark}"
    }

    override fun initializeListeners() {
        button_activity_registration_goBack.setOnClickListener{
            fragmentManager?.popBackStack()
        }
    }
}