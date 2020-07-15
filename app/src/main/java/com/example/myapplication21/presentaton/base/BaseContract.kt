package com.example.myapplication21.presentaton.base

interface BaseContract {

    interface BaseView{
        fun initializeViews()

        fun initializeListeners()
    }

    interface BasePresenter<T>{
        fun attach(view: T)

        fun onStop()
    }
}