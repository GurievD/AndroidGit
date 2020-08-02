package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.SubjectsFragment

class StudentsActivity: BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeDefaultFragment(SubjectsFragment(), R.id.relativeLayout_activity_students_fragmentContainer, "SubjectsFragment")
    }

    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }


}