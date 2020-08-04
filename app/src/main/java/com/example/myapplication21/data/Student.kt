package com.example.myapplication21.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey(autoGenerate = true)
    var studentId: Int = 0
    var studentName: String = ""

    override fun toString(): String {
        return "ID: $studentId Имя студента: $studentName"
    }
}