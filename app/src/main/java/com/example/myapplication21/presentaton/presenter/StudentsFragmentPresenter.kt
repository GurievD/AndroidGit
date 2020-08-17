package com.example.myapplication21.presentaton.presenter

import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.myapplication21.di.component.DaggerDatabaseComponent
import com.example.myapplication21.di.module.DatabaseModule
import com.example.myapplication21.domain.Student
import com.example.myapplication21.domain.usecase.function.db.DatabaseUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByMarkUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByNameUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByRandomUseCase
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class StudentsFragmentPresenter(context: Context) : StudentsFragmentContract.Presenter {

    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var sortByNameUseCase: SortByNameUseCase = SortByNameUseCase()
    var sortByMarkUseCase: SortByMarkUseCase = SortByMarkUseCase()
    var sortByRandomUseCase: SortByRandomUseCase = SortByRandomUseCase()
    var context: Context? = context

    @Inject
    lateinit var databaseUseCase: DatabaseUseCase

    var arrayListOfStudents: ArrayList<Student> = arrayListOf(
        Student("Alexei", "Sidorov", "Good student", 11, 6.7F, null, true),
        Student("Denis", "Guryev", "Good student", 10, 7.8F, null, true),
        Student("Alexandr", "Petrov", "Good student", 7, 9.3F, null, true),
        Student("Pavel", "Smirnov", "Good student", 7, 8.9F, null, true),
        Student("Vladimir", "Vasilyev", "Good student", 8, 10.5F, null, true),
        Student("Mikhail", "Krasnov", "Good student", 9, 11.8F, null, true)

    )

//        override fun initializeData(students : ArrayList<Student>){
////
////        studentsFragmentContractView?.processData(arrayListOfStudents.apply {
////            add(Student("Alexei", "Sidorov", "Good student", bitmapList[0], 7, 6.7F,  true))
////            add(Student("Denis", "Guryev", "Ordinary student", bitmapList[1], 8, 4.6F, true))
////            add(Student("Alexandr", "Petrov", "Great student", bitmapList[2], 8, 6.9F, true))
////            add(Student("Dmitry", "Dmitrov", "Ordinary student", bitmapList[3], 9, 3.9F, true))
////            add(Student("Pavel", "Smirnov", "Ordinary student", bitmapList[4], 11, 4.3F, true))
////            add(Student("Vladimir", "Vasilyev", "Bad student", bitmapList[5], 9, 2.6F, true))
////            add(Student("Maxim", "Romanyuk", "Good student", bitmapList[6], 7, 5.9F, true))
////            add(Student("Roman", "Kondratev", "Perfect student", bitmapList[7], 10, 9.8F, true))
////            })
////        studentsFragmentContractView?.initiateUpdateAdapter()
////    }

    init {
        DaggerDatabaseComponent.builder().databaseModule(DatabaseModule(context)).build().inject(this)
    }

    override fun attach(view: StudentsFragmentContract.View) {
        this.studentsFragmentContractView = view
    }

    override fun initializeData() {
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateSortStudentsByName() {
        sortByNameUseCase.initiateSortStudentsByName(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateSortStudentsRandom() {
        sortByRandomUseCase.initiateSortStudentsRandom(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateSortStudentsByMark() {
        sortByMarkUseCase.initiateSortStudentsByMark(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateFindStudentByQuery(editText: String) {
        val filteredListOfStudents: ArrayList<Student> = ArrayList()

        for (item in arrayListOfStudents) {
            if (item.studentName.toLowerCase(Locale.ROOT).contains(editText.toLowerCase(Locale.ROOT)) ||
                item.studentLastName.toLowerCase(Locale.ROOT).contains(editText.toLowerCase(Locale.ROOT)) ||
                item.studentDescription.toLowerCase(Locale.ROOT).contains(editText.toLowerCase(Locale.ROOT)) ||
                item.studentMark.toString().contains(editText)) {
                filteredListOfStudents.add(item)
                studentsFragmentContractView?.processData(filteredListOfStudents)
                studentsFragmentContractView?.initiateUpdateAdapter()
            }
        }
    }

    override fun initiateAddStudent(student: Student) {
        arrayListOfStudents.add(student)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun onStop() {
        studentsFragmentContractView = null
    }

    fun initiateDatabaseUseCases() {
        databaseUseCase.initiateInsertStudent(com.example.myapplication21.data.Student().apply {
            name = "Вася"
            subjectId = 1
        })
        databaseUseCase.initiateInsertStudentsList(listOf(com.example.myapplication21.data.Student().apply {
                name = "Денис"
                subjectId = 1
            }, com.example.myapplication21.data.Student().apply {
                name = "Василий"
                subjectId = 2
            }, com.example.myapplication21.data.Student().apply {
                name = "Пётр"
                subjectId = 2
            }, com.example.myapplication21.data.Student().apply {
                name = "Владимир"
                subjectId = 3
            }, com.example.myapplication21.data.Student().apply {
                name = "Николай"
                subjectId = 3
            }))
        databaseUseCase.initiateInsertSubject(com.example.myapplication21.data.Subject().apply {
            title = "11A"
        })
        databaseUseCase.initiateInsertSubjectsList(listOf(com.example.myapplication21.data.Subject().apply {
            title = "9B"
        }, com.example.myapplication21.data.Subject().apply {
            title = "8C"
        }))

        Log.d("Получить всех студентов", databaseUseCase.initiateGetAllStudents().toString())
        Log.d("Получить все классы", databaseUseCase.initiateGetAllSubjects().toString())
        Log.d("Взаимосвязь", databaseUseCase.initiateGetStudentsBySubjectTitle("11A").toString())

    }
}