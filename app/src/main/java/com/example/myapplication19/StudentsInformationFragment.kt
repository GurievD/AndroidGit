package com.example.myapplication19

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class StudentsInformationFragment: Fragment() {
    var textViewToShowStudentDescription: TextView? = null
    var textViewToShowStudentName: TextView? = null
    var imageViewToShowPicture: ImageView? = null
    var rootView: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.info_fragment_students,
            container,
            false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textViewToShowStudentDescription = view.findViewById(R.id.textView_info_fragment_students_studentDescription)
        textViewToShowStudentName = view.findViewById(R.id.textView_info_fragment_students_studentName)
        imageViewToShowPicture = view.findViewById(R.id.imageView_info_fragment_students_showPicture)

        textViewToShowStudentDescription?.text = "Студент"
        textViewToShowStudentName?.text = "Денис"
        imageViewToShowPicture?.setImageResource(R.drawable.noavatar)


    }

}