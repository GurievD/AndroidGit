package com.example.myapplication21.di.component

import com.example.myapplication21.di.module.DatabaseModule
import com.example.myapplication21.presentaton.fragment.StudentsFragment
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import dagger.Component

@Component(modules = [DatabaseModule::class])
interface DatabaseComponent {
    fun inject(studentsFragmentPresenter: StudentsFragmentPresenter)
}