package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.NotesFragment

class NotesActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notes)

        initializeDefaultFragment(NotesFragment(), R.id.relativeLayout_activity_notes_fragmentContainer, "NotesFragment")
    }

    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }
}