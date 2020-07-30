package com.example.myapplication21.presentaton.presenter

import android.graphics.Bitmap
import android.graphics.Color
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.contract.SubjectsFragmentContract

class SubjectsFragmentPresenter : SubjectsFragmentContract.Presenter {

    var subjectsFragmentContractView: SubjectsFragmentContract.View? = null

    var arrayListOfSubjects: ArrayList<Subject> = ArrayList()

    var arrayListOfStudents: ArrayList<Student> = ArrayList()
    var arrayListOfStudents2: ArrayList<Student> = ArrayList()

    var arrayListOfBitmaps: ArrayList<Bitmap> = arrayListOf(
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565),
        Bitmap.createBitmap(200, 200, Bitmap.Config.RGB_565)
    )

    override fun initializeData() {

        arrayListOfStudents.apply {
            add(Student("Misha", "Petrov", "Good student", arrayListOfBitmaps[1], 7.8F, true))
        }
        arrayListOfStudents2.apply {
            add(Student("Petya", "Vasilev", "Good student", arrayListOfBitmaps[2], 8.9F, true ))
        }

        subjectsFragmentContractView?.processData(arrayListOfSubjects.apply {
            add(Subject("SEP-171", arrayListOfStudents))
            add(Subject("STEP-172", arrayListOfStudents2))
        })

        subjectsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun attach(view: SubjectsFragmentContract.View) {
        this.subjectsFragmentContractView = view
        setBitmapColors()
    }

    override fun onStop() {
        this.subjectsFragmentContractView = null
    }

    fun setBitmapColors() {
        arrayListOfBitmaps[0].eraseColor(Color.BLUE)
        arrayListOfBitmaps[1].eraseColor(Color.RED)
        arrayListOfBitmaps[2].eraseColor(Color.CYAN)
        arrayListOfBitmaps[3].eraseColor(Color.GREEN)
        arrayListOfBitmaps[4].eraseColor(Color.GRAY)
        arrayListOfBitmaps[5].eraseColor(Color.YELLOW)
        arrayListOfBitmaps[6].eraseColor(Color.MAGENTA)
        arrayListOfBitmaps[7].eraseColor(Color.BLACK)
    }
}