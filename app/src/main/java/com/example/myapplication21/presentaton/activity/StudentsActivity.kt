package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.StudentsFragment

class StudentsActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeDefaultFragment(StudentsFragment(), R.id.relativeLayout_activity_students_fragmentContainer, "StudentsFragment")
    }

    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }


}