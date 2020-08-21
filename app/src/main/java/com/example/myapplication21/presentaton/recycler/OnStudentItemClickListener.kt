package com.example.myapplication21.presentaton.recycler

import com.example.myapplication21.domain.Student

interface OnStudentItemClickListener {
    fun onStudentItemClick(item: Student, adapterPosition: Int)
    fun onStudentItemClick2(item: Student, adapterPosition: Int)
}