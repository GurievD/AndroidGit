package com.example.myapplication21.presentaton.contract

import com.example.myapplication21.data.Student
import com.example.myapplication21.presentaton.base.BaseContract

interface StudentsFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(students: ArrayList<Student>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateSortStudentsByName()

        fun initiateSortStudentsRandom()

    }
}