package com.example.myapplication21.presentaton.recycler

import com.example.myapplication21.data.Student

interface OnStudentItemClickListener {
    fun onStudentItemClick(item: Student, adapterPosition: Int)
}