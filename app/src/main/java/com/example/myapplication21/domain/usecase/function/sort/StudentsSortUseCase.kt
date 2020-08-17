package com.example.myapplication21.domain.usecase.function.sort

import com.example.myapplication21.domain.Student

class StudentsSortUseCase {
    fun initiateSortStudentsByMark(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { sortByDescending { student -> student.studentMark } }
    }
    fun initiateSortStudentsByName(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { sortBy{ student ->  student.studentName} }
    }
    fun initiateSortStudentsRandom(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { shuffle() }
    }
}