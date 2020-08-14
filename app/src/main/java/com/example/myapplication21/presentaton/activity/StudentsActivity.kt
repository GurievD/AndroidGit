package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import android.widget.Button
import com.example.myapplication21.R
import com.example.myapplication21.domain.Student
import com.example.myapplication21.presentaton.fragment.StudentsFragment
import com.example.myapplication21.presentaton.fragment.ViewPagerFragment
import kotlinx.android.synthetic.main.fragment_students.*

class StudentsActivity: BaseActivity() {
    var fragmentArguments: Bundle? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)
        initializeDefaultFragment(StudentsFragment(), R.id.relativeLayout_activity_students_fragmentContainer, "StudentsFragment")

    }

    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }


}