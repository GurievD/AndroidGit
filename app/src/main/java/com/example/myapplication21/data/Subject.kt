package com.example.myapplication21.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Subject {
    @PrimaryKey(autoGenerate = true)
    var subjectId: Int = 0
    var subjectTitle: String = ""

    override fun toString(): String {
        return "ID: $subjectId Имя группы: $subjectTitle"
    }
}