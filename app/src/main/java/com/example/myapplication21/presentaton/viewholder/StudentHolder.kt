package com.example.myapplication21.presentaton.viewholder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.data.Student
import com.example.myapplication21.presentaton.recycler.OnStudentItemClickListener
import kotlinx.android.synthetic.main.list_item.view.*

class StudentHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var studentName: TextView = itemView.textView_list_item_studentName

    var studentGroup: TextView = itemView.textView_list_item_studentGroup
    var buttonMoreAboutStudent: Button = itemView.button_list_item_moreAboutStudent
    fun initiateBind(student: Student, action: OnStudentItemClickListener){
        studentName.text = student.studentName
        studentGroup.text = "${student.studentGroup}-й класс"

        buttonMoreAboutStudent.setOnClickListener {
            action.onItemClick(student, adapterPosition)
        }
    }
}