package com.example.myapplication21.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction

@Dao
interface SubjectDAO {
    @Insert
    fun initiateInsertSubject(subject: Subject)

    @Insert
    fun initiateInsertSubjectsList(subjects: List<Subject>)

    @Query("SELECT * FROM subject WHERE id = :id")
    fun initiateGetSubjectById(id: Int): Subject

    @Query("SELECT * FROM subject")
    fun initiateGetAllSubjects(): List<Subject>

    @Query("DELETE FROM subject WHERE id = :id")
    fun initiateDeleteSubjectById(id: Int)

    @Query("DELETE FROM subject")
    fun initiateDeleteAllSubjects()

    @Transaction
    @Query("SELECT stud.id, stud.name as studName, subj.id, subj.title FROM student stud JOIN subject subj ON stud.subject_id = subj.id WHERE subj.title = :subject_title")
    fun getStudentsBySubjectTitle(subject_title: String): List<SubjectWithStudents>
}