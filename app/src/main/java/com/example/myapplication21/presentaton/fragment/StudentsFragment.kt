package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.presentaton.adapter.StudentAdapter
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnStudentItemClickListener
import kotlinx.android.synthetic.main.fragment_students.*

class StudentsFragment: Fragment(), StudentsFragmentContract.View, OnStudentItemClickListener {
    var rootView: View? = null
    var arrayListOfStudents: ArrayList<Student> = ArrayList()
    var studentAdapter: StudentAdapter? = null
     lateinit var studentsFragmentPresenter: StudentsFragmentPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_students,
            container,
            false)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        studentsFragmentPresenter.initializeData()
        studentsFragmentPresenter.studentsSortUseCase.initiateSortStudentsByName(arrayListOfStudents)
    }

    fun setArguments(studentName: String, studentLastName: String, studentGroup: Int, studentDescription: String, studentImage: Int): StudentsInformationFragment {
        val studentsInformationFragment = StudentsInformationFragment()
        val bundleOfArguments = Bundle()
        bundleOfArguments.putString("name", studentName)
        bundleOfArguments.putString("lastName", studentLastName)
        bundleOfArguments.putInt("group", studentGroup)
        bundleOfArguments.putString("description", studentDescription)
        bundleOfArguments.putInt("image", studentImage)
        studentsInformationFragment.arguments = bundleOfArguments
        return studentsInformationFragment
    }

    override fun onItemClick(item: Student, position: Int) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val studentsInformationFragment: StudentsInformationFragment = setArguments(item.studentName, item.studentLastName, item.studentGroup, item.studentDescription, item.studentImage)

        fragmentManager?.executePendingTransactions()

        fragmentTransaction?.replace(R.id.relativeLayout_activity_students_fragmentContainer, studentsInformationFragment)

        fragmentTransaction?.addToBackStack("name")
        fragmentTransaction?.commit()
    }

    override fun initializePresenter() {
        studentsFragmentPresenter = StudentsFragmentPresenter()
        studentsFragmentPresenter.attach(this)
    }

    override fun initializeViews(){
        recyclerView_fragment_students_list?.visibility = View.VISIBLE
    }

    override fun initializeLayoutManager(){
        recyclerView_fragment_students_list?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter(){
        studentAdapter = StudentAdapter(context, arrayListOfStudents, this)
        recyclerView_fragment_students_list?.adapter = studentAdapter
    }

    override fun processData(students: ArrayList<Student>) {
        this.arrayListOfStudents.clear()
        this.arrayListOfStudents.addAll(students)
    }

    override fun initiateUpdateAdapter() {
        studentAdapter?.notifyDataSetChanged()
    }

    override fun initializeListeners() {
//        button_fragment_students_action?.setOnClickListener(this)
    }

}