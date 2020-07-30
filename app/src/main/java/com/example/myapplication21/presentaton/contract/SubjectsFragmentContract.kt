package com.example.myapplication21.presentaton.contract

import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.base.BaseContract

interface SubjectsFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(subjects: ArrayList<Subject>)

    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()
    }
}