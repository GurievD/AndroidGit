package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.adapter.SubjectsAdapter
import com.example.myapplication21.presentaton.contract.SubjectsFragmentContract
import com.example.myapplication21.presentaton.presenter.SubjectsFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnSubjectItemClickListener
import kotlinx.android.synthetic.main.fragment_subjects.*

class SubjectsFragment: BaseFragment(), SubjectsFragmentContract.View, OnSubjectItemClickListener {
    var arrayListOfSubjects : ArrayList<Subject> = ArrayList()
    var subjectsAdapter : SubjectsAdapter? = null
    var student: Student? = null

    lateinit var subjectsFragmentPresenter : SubjectsFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_subjects, container, false);
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        subjectsFragmentPresenter.initializeData()
    }

    override fun onClick(v: View?) {
        when(v?.id)
        {
            R.id.button_fragment_subjects_updateList -> {
                initiateUpdateAdapter()
            }
        }
    }

    override fun initializePresenter() {
        subjectsFragmentPresenter = SubjectsFragmentPresenter()
        subjectsFragmentPresenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerView_fragment_subjects_list?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        subjectsAdapter = SubjectsAdapter(context, arrayListOfSubjects, this)
        recyclerView_fragment_subjects_list?.adapter = subjectsAdapter
    }

    override fun initiateUpdateAdapter() {
        subjectsAdapter?.notifyDataSetChanged()
    }

    override fun processData(subjects: ArrayList<Subject>) {
        this.arrayListOfSubjects.clear()
        this.arrayListOfSubjects.addAll(subjects)
    }

    override fun initializeViews() {
    }

    override fun initializeListeners() {
        button_fragment_subjects_updateList.setOnClickListener(this)
    }

    override fun onSubjectItemClick(item: Subject, adapterPosition: Int) {
        val studentsFragment = baseArguments(StudentsFragment(), null, null, subjectsAdapter?.arrayListOfSubjects!![adapterPosition])
        baseTransaction(studentsFragment, "MoreAboutSubject")
    }
}