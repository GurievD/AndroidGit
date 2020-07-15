package com.example.myapplication21.domain

import com.example.myapplication21.data.Student

class StudentsSortUseCase {
    fun initiateSortStudentsByName(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { sortBy{ student ->  student.studentName} }
    }

    fun initiateSortStudentsRandom(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { shuffle() }
    }
}