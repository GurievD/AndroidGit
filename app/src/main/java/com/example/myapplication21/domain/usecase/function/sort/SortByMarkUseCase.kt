package com.example.myapplication21.domain.usecase.function.sort

import com.example.myapplication21.domain.Student


class SortByMarkUseCase {
    fun initiateSortStudentsByMark(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { sortByDescending { student -> student.studentMark } }
    }
}