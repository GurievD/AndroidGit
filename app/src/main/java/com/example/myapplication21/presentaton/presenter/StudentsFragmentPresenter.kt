package com.example.myapplication21.presentaton.presenter

import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.domain.StudentsSortUseCase
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract

class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {
    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var studentsSortUseCase: StudentsSortUseCase = StudentsSortUseCase()
    var arrayListOfStudents: ArrayList<Student> = ArrayList()

    override fun attach(view: StudentsFragmentContract.View) {
        this.studentsFragmentContractView = view
    }

    override fun initializeData(){
        studentsFragmentContractView?.processData(arrayListOfStudents.apply {
            add(Student("Алексей", "Сидоров", "Хороший студент", R.drawable.noavatar, 7))
            add(Student("Денис", "Гурьев", "Обычный студент", R.drawable.noavatar, 8))
            add(Student("Александр", "Петров", "Отличный студент", R.drawable.noavatar, 8))
            add(Student("Дмитрий", "Дмитров", "Обычный студент", R.drawable.noavatar, 9))
            add(Student("Павел", "Смирнов", "Обычный студент", R.drawable.noavatar, 11))
            add(Student("Владимир", "Васильев", "Плохой студент", R.drawable.noavatar, 9))
            add(Student("Михаил", "Романюк", "Хороший студент", R.drawable.noavatar, 7))
            add(Student("Роман", "Кондратьев", "Прекрасный студент", R.drawable.noavatar, 10))
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

    override fun onStop() {
        studentsFragmentContractView = null
    }
}