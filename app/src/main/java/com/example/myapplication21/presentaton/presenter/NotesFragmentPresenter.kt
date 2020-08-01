package com.example.myapplication21.presentaton.presenter

import android.content.Context
import android.os.Build
import com.example.myapplication21.data.Note
import com.example.myapplication21.presentaton.contract.NotesFragmentContract
import java.time.LocalDate

class NotesFragmentPresenter: NotesFragmentContract.Presenter {
    var notesFragmentContractView: NotesFragmentContract.View? = null
    var arrayListOfNotes: ArrayList<Note> = ArrayList()
    var context: Context? = null
    override fun initializeData() {
        notesFragmentContractView?.processData(arrayListOfNotes.apply {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                add(Note("котик", "Покормить котика", "${LocalDate.now()}", null))
                add(Note("домашние задания", "Доделать все домашки", "${LocalDate.now().plusDays(1)}", null))
                add(Note("практические задания", "Доделать все практические", "${LocalDate.now().plusDays(2)}", null))
                add(Note("финальный проект", "Сдать финальный проект и не облажаться!", "${LocalDate.now().plusDays(3)}", null))
            }
        })
    }

    override fun initiateAddNote(note: Note) {
        arrayListOfNotes.add(note)
        notesFragmentContractView?.processData(arrayListOfNotes)
        notesFragmentContractView?.initiateUpdateAdapter()
    }

    override fun attach(view: NotesFragmentContract.View) {
        this.notesFragmentContractView = view
    }

    override fun onStop() {
        notesFragmentContractView = null
    }
}