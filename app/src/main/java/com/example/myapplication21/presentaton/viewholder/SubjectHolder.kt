package com.example.myapplication21.presentaton.viewholder

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.recycler.OnSubjectItemClickListener
import kotlinx.android.synthetic.main.subject_list_item.view.*

class SubjectHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    var subjectTitle: TextView = itemView.textView_subject_list_item_subjectTitle
    var subjectSize: TextView = itemView.textView_subject_list_item_subjectSize
    var buttonMoreAboutSubject: Button = itemView.button_subject_list_item_moreAboutSubject

    fun initiateBind(subject: Subject, action: OnSubjectItemClickListener)
    {
        subjectTitle.text = "Группа: ${subject.subjectTitle.toString()}"
        subjectSize.text = "Cтудентов в группе: ${subject.arrayListOfStudents.size.toString()}"

        buttonMoreAboutSubject.setOnClickListener{
            action.onSubjectItemClick(subject, adapterPosition)
        }
    }
}