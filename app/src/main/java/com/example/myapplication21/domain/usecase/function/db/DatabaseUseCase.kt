package com.example.myapplication21.domain.usecase.function.db

import android.content.Context
import androidx.room.Room
import com.example.myapplication21.data.MyRoomDB
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject
import com.example.myapplication21.data.SubjectWithStudents

class DatabaseUseCase(context: Context) {
    private var myRoomDB: MyRoomDB = Room.databaseBuilder(
        context,
        MyRoomDB::class.java,
        "MyRoomDatabase"
    ).allowMainThreadQueries().build()

    fun initiateInsertStudent(student: Student) {
        myRoomDB.getStudentDAO().initiateInsertStudent(student)
    }

    fun initiateInsertStudentsList(students: List<Student>) {
        myRoomDB.getStudentDAO().initiateInsertStudentsList(students)
    }

    fun initiateInsertSubject(subject: Subject) {
        myRoomDB.getSubjectDAO().initiateInsertSubject(subject)
    }

    fun initiateInsertSubjectsList(subjects: List<Subject>) {
        myRoomDB.getSubjectDAO().initiateInsertSubjectsList(subjects)
    }

    fun initiateGetAllStudents(): List<Student> {
        return myRoomDB.getStudentDAO().initiateGetAllStudents()
    }

    fun initiateGetAllSubjects(): List<Subject> {
        return myRoomDB.getSubjectDAO().initiateGetAllSubjects()
    }

    fun initiateGetStudentsBySubjectTitle(subject_title: String): List<SubjectWithStudents> {
        return myRoomDB.getSubjectDAO().getStudentsBySubjectTitle(subject_title)
    }

}