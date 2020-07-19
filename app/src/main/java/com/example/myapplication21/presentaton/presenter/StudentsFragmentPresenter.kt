package com.example.myapplication21.presentaton.presenter

import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.domain.StudentsSortUseCase
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import java.util.*
import kotlin.collections.ArrayList

class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {
    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var studentsSortUseCase: StudentsSortUseCase = StudentsSortUseCase()
    var arrayListOfStudents: ArrayList<Student> = ArrayList()

    override fun attach(view: StudentsFragmentContract.View) {
        this.studentsFragmentContractView = view
    }

    override fun initializeData(){
        studentsFragmentContractView?.processData(arrayListOfStudents.apply {
            add(Student("Alexei", "Sidorov", "Good student", R.drawable.noavatar, 7, 6.7F))
            add(Student("Denis", "Guryev", "Ordinary student", R.drawable.noavatar, 8, 4.6F))
            add(Student("Alexandr", "Petrov", "Great student", R.drawable.noavatar, 8, 6.9F))
            add(Student("Dmitry", "Dmitrov", "Ordinary student", R.drawable.noavatar, 9, 3.9F))
            add(Student("Pavel", "Smirnov", "Ordinary student", R.drawable.noavatar, 11, 4.3F))
            add(Student("Vladimir", "Vasilyev", "Bad student", R.drawable.noavatar, 9, 2.6F))
            add(Student("Maxim", "Romanyuk", "Good student", R.drawable.noavatar, 7, 5.9F))
            add(Student("Roman", "Kondratev", "Perfect student", R.drawable.noavatar, 10, 9.8F))
        })
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateSortStudentsByName() {
        studentsSortUseCase.initiateSortStudentsByName(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

     override fun initiateSortStudentsRandom() {
        studentsSortUseCase.initiateSortStudentsRandom(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateSortStudentsByMark() {
        studentsSortUseCase.initiateSortStudentsByMark(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun initiateFindStudentByQuery(editText: String) {
        val filteredListOfStudents: ArrayList<Student> = ArrayList()

        for (item in arrayListOfStudents) {
            if (item.studentName.toLowerCase(Locale.ROOT).contains(editText.toLowerCase(Locale.ROOT)) ||
                item.studentLastName.toLowerCase(Locale.ROOT).contains(editText.toLowerCase(Locale.ROOT)) ||
                item.studentDescription.toLowerCase(Locale.ROOT).contains(editText.toLowerCase(Locale.ROOT)) ||
                item.studentGroup.toString().contains(editText) ||
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
}