package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.base.BaseContract
import kotlinx.android.synthetic.main.activity_registration.*

class StudentsInformationFragment: Fragment(), BaseContract.BaseView {
    var rootView: View? = null

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
        val getImage = arguments!!.getInt("image")
        val getName = arguments!!.getString("name")
        val getGroup = arguments!!.getInt("group")
        val getLastName = arguments!!.getString("lastName")
        val getDescription = arguments!!.getString("description")
        val getMark = arguments!!.getFloat("mark")

        textView_activity_registration_showNameAndLastName.text = "$getName $getLastName"
        textView_activity_registration_showDescription.text = "$getDescription"
        textView_activity_registration_showGroup.text = "$getGroup-й класс"
        imageView_activity_registration_showImage.setImageResource(getImage)
        textView_activity_registration_showMark.text = "Средняя оценка: $getMark"
    }

    override fun initializeListeners() {
        button_activity_registration_goBack.setOnClickListener{
            fragmentManager?.popBackStack()
        }
    }
}