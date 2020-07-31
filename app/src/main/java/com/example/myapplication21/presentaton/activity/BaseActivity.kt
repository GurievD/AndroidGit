package com.example.myapplication21.presentaton.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity: AppCompatActivity() {
    abstract fun initializeDefaultFragment()

    abstract fun displayFragment(fragment : Fragment)

    abstract fun instanceOfHostActivity(): BaseActivity

}