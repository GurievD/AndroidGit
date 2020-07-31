package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject

abstract class BaseFragment: Fragment(), View.OnClickListener {
    fun baseTransaction(fragment: Fragment, tag: String) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentManager?.executePendingTransactions()
        fragmentTransaction?.add(R.id.relativeLayout_activity_students_fragmentContainer, fragment, tag)
        fragmentTransaction?.hide(this)
        fragmentTransaction?.addToBackStack("name")
        fragmentTransaction?.commit()
    }
    fun baseArguments(fragment: Fragment, studentObject: Student? = null, studentSubject: Subject? = null, subject: Subject? = null): Fragment {
        val bundleOfArguments = Bundle()
        bundleOfArguments.putParcelable("StudentObject", studentObject)
        bundleOfArguments.putParcelable("StudentSubject", studentSubject)
        bundleOfArguments.putParcelable("Subject", subject)
        fragment.arguments = bundleOfArguments
        return fragment
    }
}