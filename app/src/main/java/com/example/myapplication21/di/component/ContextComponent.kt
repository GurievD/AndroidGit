package com.example.myapplication21.di.component

import com.example.myapplication21.di.module.ContextModule
import com.example.myapplication21.presentaton.fragment.*
import dagger.Component

@Component(modules = [ContextModule::class])
interface ContextComponent {
    fun injectCarouselFragment(carouselFragment: CarouselFragment)
    fun injectMainPageFragment(mainPageFragment: MainPageFragment)
    fun injectNoteFormFragment(noteFormFragment: NoteFormFragment)
    fun injectNotesFragment(notesFragment: NotesFragment)
    fun injectStudentFormFragment(studentFormFragment: StudentFormFragment)
    fun injectStudentsFragment(studentsFragment: StudentsFragment)

}