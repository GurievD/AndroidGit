package com.example.myapplication21.domain.usecase.function.sort

import com.example.myapplication21.data.Student

class SortByNameUseCase {
    fun initiateSortStudentsByName(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { sortBy{ student ->  student.studentName} }
    }
}