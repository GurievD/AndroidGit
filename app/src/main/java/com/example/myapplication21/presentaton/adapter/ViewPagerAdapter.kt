package com.example.myapplication21.presentaton.adapter

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter
import com.example.myapplication21.domain.Student
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import com.example.myapplication21.presentaton.fragment.StudentFormFragment
import com.example.myapplication21.presentaton.fragment.StudentsInformationFragment
import com.example.myapplication21.presentaton.fragment.ViewPagerFragment
import java.lang.reflect.Array.newInstance


class ViewPagerAdapter(fragmentManager: FragmentManager, var arrayListOfStudents: ArrayList<Student>): FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        val fragment = StudentsInformationFragment()
        return fragment.apply {
            arguments = Bundle().apply {
                putParcelable("StudentObject", arrayListOfStudents[position])
            }
        }
    }

    override fun getCount(): Int {
        return arrayListOfStudents.size
    }
}