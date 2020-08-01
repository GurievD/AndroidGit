package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject
import com.example.myapplication21.presentaton.adapter.StudentsAdapter
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnStudentItemClickListener
import com.example.myapplication21.presentaton.utils.getBest3Students
import kotlinx.android.synthetic.main.fragment_students.*


class StudentsFragment: BaseFragment(), StudentsFragmentContract.View, OnStudentItemClickListener {
    var subject: Subject? = null
    var studentsAdapter: StudentsAdapter? = null

    lateinit var studentsFragmentPresenter: StudentsFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         return inflater.inflate(R.layout.fragment_students, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        studentsFragmentPresenter.initializeData(subject?.arrayListOfStudents!!)
    }

    override fun onClick(view: View?) {
            when (view?.id) {
                R.id.button_fragment_students_sortByName ->   {
                    studentsFragmentPresenter.initiateSortStudentsByName()
                    initiateUpdateAdapter()
                }
                R.id.button_fragment_students_sortByGrade -> {
                    studentsFragmentPresenter.initiateSortStudentsByMark()
                    initiateUpdateAdapter()
                }
                R.id.button_fragment_students_sortByRandom -> {
                    studentsFragmentPresenter.initiateSortStudentsRandom()
                    initiateUpdateAdapter()
                }
                R.id.FAB_fragment_students_findByQuery -> {
                    studentsFragmentPresenter.initiateFindStudentByQuery(editText_fragment_students_searchQuery.text.toString())
                    initiateUpdateAdapter()
                }
                R.id.FAB_fragment_students_clearField -> {
                    editText_fragment_students_searchQuery.text = null
                    initiateUpdateAdapter()
                }
                R.id.FAB_fragment_students_goToForm -> {
                    baseTransaction(R.id.relativeLayout_activity_students_fragmentContainer, StudentFormFragment(), "AddNewStudent")
                }
                R.id.button_fragment_students_getBack -> {
                    editText_fragment_students_searchQuery.text = null
                    studentsFragmentPresenter.initiateFindStudentByQuery("")
                    initiateUpdateAdapter()

                    fragmentManager?.popBackStack()
                }
            }
    }

    override fun initializeViews(){
        subject = arguments?.getParcelable("Subject")

        recyclerView_fragment_students_list?.visibility = View.VISIBLE
        subject?.arrayListOfStudents!!.getBest3Students()
        initiateUpdateAdapter()
    }

    override fun initializePresenter() {
        studentsFragmentPresenter = StudentsFragmentPresenter()
        studentsFragmentPresenter.attach(this)
    }

    override fun initializeLayoutManager(){
        recyclerView_fragment_students_list?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter(){
        studentsAdapter = StudentsAdapter(context, subject?.arrayListOfStudents!!, this)

        recyclerView_fragment_students_list?.adapter = studentsAdapter
    }

    override fun processData(students: ArrayList<Student>) {
        subject?.arrayListOfStudents?.clear()
        subject?.arrayListOfStudents?.addAll(students)
    }

    override fun initializeListeners() {
        button_fragment_students_sortByName.setOnClickListener(this)
        button_fragment_students_sortByGrade.setOnClickListener(this)
        button_fragment_students_sortByRandom.setOnClickListener(this)
        FAB_fragment_students_findByQuery.setOnClickListener(this)
        FAB_fragment_students_clearField.setOnClickListener(this)
        FAB_fragment_students_goToForm.setOnClickListener(this)
        button_fragment_students_getBack.setOnClickListener(this)
    }

    override fun initiateUpdateAdapter() {
        studentsAdapter?.notifyDataSetChanged()
    }

    override fun onStudentItemClick(item: Student, adapterPosition: Int) {
        val studentsInformationFragment = baseArguments(StudentsInformationFragment(), studentsAdapter?.arrayListOfStudents!![adapterPosition], subject, null)
        baseTransaction(R.id.relativeLayout_activity_students_fragmentContainer, studentsInformationFragment, "MoreAboutStudent")
    }
}