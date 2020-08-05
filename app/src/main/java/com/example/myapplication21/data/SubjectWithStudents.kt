package com.example.myapplication21.data

import androidx.room.Embedded

class SubjectWithStudents {
    @Embedded
    var subject: Subject? = null

    var studName: String = ""
    override fun toString(): String {
        return "'$subject Имя студента: $studName'"
    }
}