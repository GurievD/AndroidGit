package com.example.myapplication21.presentaton.presenter

import com.example.myapplication21.domain.Student
import com.example.myapplication21.domain.usecase.function.sort.SortByMarkUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByNameUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByRandomUseCase
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import java.util.*
import kotlin.collections.ArrayList


class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {

    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var sortByNameUseCase: SortByNameUseCase = SortByNameUseCase()
    var sortByMarkUseCase: SortByMarkUseCase = SortByMarkUseCase()
    var sortByRandomUseCase: SortByRandomUseCase = SortByRandomUseCase()
    var arrayListOfStudents: ArrayList<Student> = ArrayList()

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

    override fun initializeData() {
        studentsFragmentContractView?.processData(arrayListOfStudents.apply {
            add(
                Student(
                    "Alexei",
                    "Sidorov",
                    "Good student",
                    null,
                    11,
                    6.7F,
                    true
                )
            )
            add(
                Student(
                    "Denis",
                    "Guryev",
                    "Good student",
                    null,
                    10,
                    6.7F,
                    true
                )
            )
            add(
                Student(
                    "Alexandr",
                    "Petrov",
                    "Good student",
                    null,
                    7,
                    6.7F,
                    true
                )
            )
            add(
                Student(
                    "Pavel",
                    "Smirnov",
                    "Good student",
                    null,
                    7,
                    6.7F,
                    true
                )
            )
            add(
                Student(
                    "Vladimir",
                    "Vasilyev",
                    "Good student",
                    null,
                    8,
                    6.7F,
                    true
                )
            )

        })
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

    override fun attach(view: StudentsFragmentContract.View) {
        this.studentsFragmentContractView = view
    }

    override fun onStop() {
        studentsFragmentContractView = null
    }
}