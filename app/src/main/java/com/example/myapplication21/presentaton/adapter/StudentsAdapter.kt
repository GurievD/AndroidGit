package com.example.myapplication21.presentaton.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.domain.Student
import com.example.myapplication21.presentaton.fragment.StudentFormFragment
import com.example.myapplication21.presentaton.fragment.StudentsFragment
import com.example.myapplication21.presentaton.fragment.StudentsInformationFragment
import com.example.myapplication21.presentaton.fragment.ViewPagerFragment
import com.example.myapplication21.presentaton.recycler.OnStudentItemClickListener
import com.example.myapplication21.presentaton.viewholder.StudentHolder
import kotlinx.android.synthetic.main.fragment_viewpager.view.*

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