package com.example.myapplication21.presentaton.presenter

import android.graphics.Bitmap
import android.graphics.Color
import com.example.myapplication21.data.Student
import com.example.myapplication21.domain.StudentsSortUseCase
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import java.util.*
import kotlin.collections.ArrayList


class StudentsFragmentPresenter : StudentsFragmentContract.Presenter {
    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var studentsSortUseCase: StudentsSortUseCase = StudentsSortUseCase()
    var arrayListOfStudents: ArrayList<Student> = ArrayList()

    var bitmapList: ArrayList<Bitmap> = arrayListOf(
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565)
    )

    override fun attach(view: StudentsFragmentContract.View) {
        this.studentsFragmentContractView = view
        setBitmapColors()

    }

    override fun initializeData(){

        studentsFragmentContractView?.processData(arrayListOfStudents.apply {
            add(Student("Alexei", "Sidorov", "Good student", bitmapList[0], 7, 6.7F,  true))
            add(Student("Denis", "Guryev", "Ordinary student", bitmapList[1], 8, 4.6F, true))
            add(Student("Alexandr", "Petrov", "Great student", bitmapList[2], 8, 6.9F, true))
            add(Student("Dmitry", "Dmitrov", "Ordinary student", bitmapList[3], 9, 3.9F, true))
            add(Student("Pavel", "Smirnov", "Ordinary student", bitmapList[4], 11, 4.3F, true))
            add(Student("Vladimir", "Vasilyev", "Bad student", bitmapList[5], 9, 2.6F, true))
            add(Student("Maxim", "Romanyuk", "Good student", bitmapList[6], 7, 5.9F, true))
            add(Student("Roman", "Kondratev", "Perfect student", bitmapList[7], 10, 9.8F, true))
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

    fun setBitmapColors() {
        bitmapList[0].eraseColor(Color.BLUE)
        bitmapList[1].eraseColor(Color.RED)
        bitmapList[2].eraseColor(Color.CYAN)
        bitmapList[3].eraseColor(Color.GREEN)
        bitmapList[4].eraseColor(Color.GRAY)
        bitmapList[5].eraseColor(Color.YELLOW)
        bitmapList[6].eraseColor(Color.MAGENTA)
        bitmapList[7].eraseColor(Color.BLACK)
    }
}