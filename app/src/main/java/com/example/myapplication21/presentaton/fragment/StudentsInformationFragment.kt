package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import kotlinx.android.synthetic.main.activity_registration.*

class StudentsInformationFragment: Fragment() {
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
        val getImage = arguments!!.getInt("image")
        val getName = arguments!!.getString("name")
        val getGroup = arguments!!.getInt("group")
        val getLastName = arguments!!.getString("lastName")
        val getDescription = arguments!!.getString("description")

        textview_activity_registration_name.text = "$getName $getLastName"
        textview_activity_registration_description.text = "$getDescription"
        textview_activity_registration_group.text = "$getGroup-й класс"
        imageView_activity_registration_image.setImageResource(getImage)
    }
}