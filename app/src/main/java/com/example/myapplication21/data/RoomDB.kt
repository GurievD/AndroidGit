package com.example.myapplication21.data

import androidx.room.Database
import androidx.room.RoomDatabase

//Работает почему-то только 3-я версия или выше. 1 и 2 у меня работают некорректно
@Database(entities = [Student::class, Subject::class], version = 3)
abstract class RoomDB: RoomDatabase() {
    abstract fun getStudentDAO(): StudentDAO

    abstract fun getSubjectDAO(): SubjectDAO
}