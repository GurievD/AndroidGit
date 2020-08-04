package com.example.myapplication21.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface SubjectDAO {
    @Insert
    fun initiateInsertSubject(subject: Subject)

    @Insert
    fun initiateInsertSubjectsList(subjects: List<Subject>)

    @Query("SELECT * FROM subject WHERE subjectId = :id")
    fun initiateGetSubjectById(id: Int): Subject

    @Query("SELECT * FROM subject")
    fun initiateGetAllSubjects(): List<Subject>

    @Query("DELETE FROM subject WHERE subjectId = :id")
    fun initiateDeleteSubjectById(id: Int)

    @Query("DELETE FROM subject")
    fun initiateDeleteAllSubjects()
}