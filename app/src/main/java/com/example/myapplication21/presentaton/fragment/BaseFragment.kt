package com.example.myapplication21.presentaton.fragment

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.example.myapplication21.data.MyRoomDB
import com.example.myapplication21.domain.Student
import java.io.InputStream

abstract class BaseFragment: Fragment(), View.OnClickListener {
    fun baseTransaction(container:Int, fragment: Fragment, tag: String) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentManager?.executePendingTransactions()
        fragmentTransaction?.add(container, fragment, tag)
        fragmentTransaction?.hide(this)
        fragmentTransaction?.addToBackStack("name")
        fragmentTransaction?.commit()
    }
    fun baseArguments(fragment: Fragment, studentObject: Student? = null): Fragment {
        val bundleOfArguments = Bundle()
        bundleOfArguments.putParcelable("StudentObject", studentObject)
        fragment.arguments = bundleOfArguments
        return fragment
    }
    fun openAssets(fileName: String, bitmap: Bitmap?, imageView: ImageView): InputStream? {
        val inputStream: InputStream? = context?.assets?.open(fileName)
        val drawableCreateFromStream = Drawable.createFromStream(inputStream, null)
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
        }
        else {
            imageView.setImageDrawable(drawableCreateFromStream)
        }

        return inputStream
    }

    @SuppressLint("LongLogTag")
    fun getRoomTransactions() {
        val myRoomDatabase = Room.databaseBuilder(
            context!!,
            MyRoomDB::class.java,
            "MyRoomDB").allowMainThreadQueries().build()

        Log.d("Добавить нового студента",
            myRoomDatabase.getStudentDAO().initiateInsertStudent(com.example.myapplication21.data.Student().apply {
                name = "Олег"
                subjectId = 1
            }).toString())
        Log.d("Добавить список студентов сразу",
            myRoomDatabase.getStudentDAO().initiateInsertStudentsList(listOf(com.example.myapplication21.data.Student().apply {
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
            })).toString())
        Log.d("Добавить новый класс",
            myRoomDatabase.getSubjectDAO().initiateInsertSubject(com.example.myapplication21.data.Subject().apply {
                title = "8C"
            }).toString())
        Log.d("Добавить список классов",
            myRoomDatabase.getSubjectDAO().initiateInsertSubjectsList(listOf(com.example.myapplication21.data.Subject().apply {
                title = "9A"
            }, com.example.myapplication21.data.Subject().apply {
                title = "11B"
            })).toString())


        Log.d("Получить весь список студентов", myRoomDatabase.getStudentDAO().initiateGetAllStudents().toString())
        Log.d("Получить весь список классов", myRoomDatabase.getSubjectDAO().initiateGetAllSubjects().toString())
        Log.d("Получить индивидуального студента по id", myRoomDatabase.getStudentDAO().initiateGetStudentById(2).toString())
        Log.d("Получить индивидуальный класс по id", myRoomDatabase.getSubjectDAO().initiateGetSubjectById(3).toString())
        Log.d("Взаимосвязь", myRoomDatabase.getSubjectDAO().getStudentsBySubjectTitle("8C").toString())


        Log.d("Удалить определенного студента по ID", myRoomDatabase.getStudentDAO().initiateDeleteStudentById(2).toString())
        Log.d("Удалить всех студентов", myRoomDatabase.getStudentDAO().initiateDeleteAllStudents().toString())
        Log.d("Удалить определенный класс по ID", myRoomDatabase.getSubjectDAO().initiateDeleteSubjectById(3).toString())
        Log.d("Удалить все классы", myRoomDatabase.getSubjectDAO().initiateDeleteAllSubjects().toString())
    }
}