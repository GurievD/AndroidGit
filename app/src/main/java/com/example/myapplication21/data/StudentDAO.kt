package com.example.myapplication21.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


@Dao
interface StudentDAO {
    @Insert
    fun initiateInsertStudent(student: Student)

    @Insert
    fun initiateInsertStudentsList(students: List<Student>)

    @Query("SELECT * FROM student WHERE id = :id")
    fun initiateGetStudentById(id: Int): Student

    @Query("SELECT * FROM student")
    fun initiateGetAllStudents(): List<Student>

    @Query("DELETE FROM student WHERE id = :id")
    fun initiateDeleteStudentById(id: Int)

    @Query("DELETE FROM student")
    fun initiateDeleteAllStudents()
}