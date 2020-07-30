package com.example.myapplication21.presentaton.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.presentaton.recycler.OnStudentItemClickListener
import com.example.myapplication21.presentaton.viewholder.StudentHolder

class StudentsAdapter(var context: Context?, var arrayListOfStudents: ArrayList<Student>, var onStudentItemClickListener: OnStudentItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflateView = LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false)
        return StudentHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return arrayListOfStudents.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as StudentHolder).initiateBind(arrayListOfStudents[position], onStudentItemClickListener)
    }
}