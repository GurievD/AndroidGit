package com.example.myapplication21.presentaton.activity

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

abstract class BaseActivity: AppCompatActivity() {
    var currentFragment: Fragment? = null

    fun initializeDefaultFragment(fragment: Fragment, container: Int, tag: String){
        if(currentFragment == null){
            currentFragment = fragment

            val fragmentTransaction = supportFragmentManager.beginTransaction()

            supportFragmentManager.executePendingTransactions()

            fragmentTransaction.add(container, fragment, tag)
            fragmentTransaction.addToBackStack("Name")
            fragmentTransaction.commit()        }
    }

    abstract fun instanceOfHostActivity(): BaseActivity
}