package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.StudentsFragment

class StudentsActivity: AppCompatActivity() {
    var currentFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeDefaultFragment()
    }

    fun initializeDefaultFragment(){
        if(currentFragment == null){
            currentFragment = StudentsFragment()
            displayFragment(currentFragment!!)
        }
    }

    fun displayFragment(fragment: Fragment){
        this.currentFragment = fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        supportFragmentManager.executePendingTransactions()
        fragmentTransaction.add(R.id.relativeLayout_activity_students_fragmentContainer, fragment, "StudentsFragment")

        fragmentTransaction.addToBackStack("Name")
        fragmentTransaction.commit()
    }



}