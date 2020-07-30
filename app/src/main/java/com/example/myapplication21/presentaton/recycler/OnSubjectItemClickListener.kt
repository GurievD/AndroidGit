package com.example.myapplication21.presentaton.recycler

import com.example.myapplication21.data.Subject

interface OnSubjectItemClickListener {
    fun onSubjectItemClick(item: Subject, adapterPosition: Int)
}