package com.example.myapplication21.presentaton.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.recycler.OnSubjectItemClickListener
import com.example.myapplication21.presentaton.viewholder.SubjectHolder

class SubjectsAdapter(var context: Context?, var arrayListOfSubjects: ArrayList<Subject>, var onSubjectItemClickListener: OnSubjectItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflateView = LayoutInflater.from(context).inflate(R.layout.subject_list_item, parent, false)
        return SubjectHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return arrayListOfSubjects.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as SubjectHolder).initiateBind(arrayListOfSubjects[position], onSubjectItemClickListener)
    }
}