package com.example.myapplication21.presentaton.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.myapplication21.presentaton.fragment.MainPageFragment
import com.example.myapplication21.presentaton.fragment.NotesFragment
import com.example.myapplication21.presentaton.fragment.StudentsFragment


class CarouselAdapter(manager: FragmentManager, var context: Context) : FragmentStatePagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    var arrayListOfTabs: ArrayList<String> = arrayListOf("Главная страница", "Список студентов", "Заметки")
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> MainPageFragment()
            1 -> StudentsFragment()
            2 -> NotesFragment()
            else -> MainPageFragment()
        }
    }

    override fun getCount(): Int {
        return arrayListOfTabs.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return arrayListOfTabs[position]
    }
}