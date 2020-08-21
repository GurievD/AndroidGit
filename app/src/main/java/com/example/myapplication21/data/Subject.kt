package com.example.myapplication21.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Subject {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    var title: String = ""

    override fun toString(): String {
        return "ID группы: $id Имя группы: $title"
    }
}