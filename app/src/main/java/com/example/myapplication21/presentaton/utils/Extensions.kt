package com.example.myapplication21.presentaton.utils

import com.example.myapplication21.data.Student

fun ArrayList<Student>.getBest3Students(){
    val getStudentCount = this.count()
    this.sortByDescending{ e -> e.studentMark }
    if(getStudentCount > 3){
        for(student in 3 until getStudentCount){
            this[student].flag=false
        }
    }
}