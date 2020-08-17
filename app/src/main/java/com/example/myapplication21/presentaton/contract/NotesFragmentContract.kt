package com.example.myapplication21.presentaton.contract

import com.example.myapplication21.domain.Note
import com.example.myapplication21.presentaton.base.BaseContract

interface NotesFragmentContract {
    interface View : BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(notes: ArrayList<Note>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData()

        fun initiateAddNote(note: Note)
    }
}