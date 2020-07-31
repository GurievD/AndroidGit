package com.example.myapplication21.presentaton.presenter

import android.content.Context
import android.graphics.BitmapFactory
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.contract.SubjectsFragmentContract
import com.example.myapplication21.presentaton.fragment.StudentsInformationFragment


class SubjectsFragmentPresenter : SubjectsFragmentContract.Presenter {

    var subjectsFragmentContractView: SubjectsFragmentContract.View? = null

    var arrayListOfSubjects: ArrayList<Subject> = ArrayList()

    var arrayListOfStudents: ArrayList<Student> = ArrayList()
    var arrayListOfStudents2: ArrayList<Student> = ArrayList()
    var context: Context? = null
    var studentsInformationFragment: StudentsInformationFragment = StudentsInformationFragment()

    override fun initializeData() {

        arrayListOfStudents.apply {
            add(Student("Misha", "Petrov", "Good student", BitmapFactory.decodeStream(studentsInformationFragment.openAssets()), 7.8F, true))
        }
        arrayListOfStudents2.apply {
            add(Student("Petya", "Vasilev", "Good student", BitmapFactory.decodeStream(studentsInformationFragment.openAssets()), 8.9F, true ))
        }

        subjectsFragmentContractView?.processData(arrayListOfSubjects.apply {
            add(Subject("SEP-171", arrayListOfStudents))
            add(Subject("STEP-172", arrayListOfStudents2))
        })

        subjectsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun attach(view: SubjectsFragmentContract.View) {
        this.subjectsFragmentContractView = view
    }

    override fun onStop() {
        this.subjectsFragmentContractView = null
    }
}