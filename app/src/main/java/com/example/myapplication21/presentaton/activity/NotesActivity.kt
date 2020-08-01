package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.NotesFragment

class NotesActivity: BaseActivity() {
    var currentFragment: Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        initializeDefaultFragment()

    }

    override fun initializeDefaultFragment() {
        if (currentFragment == null) {
            currentFragment = NotesFragment()
            displayFragment(currentFragment!!)
        }
    }

    override fun displayFragment(fragment: Fragment) {
        this.currentFragment = fragment

        val fragmentTransaction = supportFragmentManager.beginTransaction()

        supportFragmentManager.executePendingTransactions()

        fragmentTransaction.add(R.id.relativeLayout_activity_notes_fragmentContainer, fragment, "NotesFragment")
        fragmentTransaction.addToBackStack("Name")
        fragmentTransaction.commit()
    }

    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }
}