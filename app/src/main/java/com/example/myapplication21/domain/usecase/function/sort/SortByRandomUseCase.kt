package com.example.myapplication21.domain.usecase.function.sort

import com.example.myapplication21.data.Student

class SortByRandomUseCase {
    fun initiateSortStudentsRandom(arrayListOfStudents: ArrayList<Student>) : ArrayList<Student>? {
        return arrayListOfStudents.apply { shuffle() }
    }
}