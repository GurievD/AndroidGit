package com.example.myapplication21.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Student {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var name: String = ""

    @ColumnInfo(name = "subject_id")
    var subjectId: Int = 0

    override fun toString(): String {
        return "ID: $id Имя студента: $name Класс студента: $subjectId"
    }
}
