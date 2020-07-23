package com.example.myapplication21.presentaton.fragment

import android.graphics.Bitmap
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
import com.example.myapplication21.presentaton.utils.getBest3Students
import kotlinx.android.synthetic.main.fragment_students.*


class StudentsFragment: Fragment(), StudentsFragmentContract.View, OnStudentItemClickListener, View.OnClickListener {
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
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        studentsFragmentPresenter.initializeData()
        initializeViews()
        initializeListeners()

    }

    fun setArguments(studentName: String, studentLastName: String, studentGroup: Int, studentDescription: String, studentImage: Bitmap?, studentMark: Float): StudentsInformationFragment {
        val studentsInformationFragment = StudentsInformationFragment()
        val bundleOfArguments = Bundle()

        bundleOfArguments.putString("name", studentName)
        bundleOfArguments.putString("lastName", studentLastName)
        bundleOfArguments.putInt("group", studentGroup)
        bundleOfArguments.putString("description", studentDescription)
        bundleOfArguments.putParcelable("bm", studentImage)
        bundleOfArguments.putFloat("mark", studentMark)
        studentsInformationFragment.arguments = bundleOfArguments

        return studentsInformationFragment
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
                    val fragmentTransaction = fragmentManager?.beginTransaction()

                    fragmentManager?.executePendingTransactions()
                    fragmentTransaction?.add(R.id.relativeLayout_activity_students_fragmentContainer, StudentFormFragment(), "AddNewStudent")
                    fragmentTransaction?.hide(this)
                    fragmentTransaction?.addToBackStack("name")
                    fragmentTransaction?.commit()

                }
            }
    }

    override fun onItemClick(item: Student, position: Int) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        val studentsInformationFragment: StudentsInformationFragment = setArguments(item.studentName, item.studentLastName, item.studentGroup, item.studentDescription, item.avatar, item.studentMark)

        fragmentManager?.executePendingTransactions()

        fragmentTransaction?.add(R.id.relativeLayout_activity_students_fragmentContainer, studentsInformationFragment, "MoreAboutStudent")
        fragmentTransaction?.hide(this)
        fragmentTransaction?.addToBackStack("name")
        fragmentTransaction?.commit()
    }

    override fun initializePresenter() {
        studentsFragmentPresenter = StudentsFragmentPresenter()
        studentsFragmentPresenter.attach(this)
    }

    override fun initializeViews(){
        recyclerView_fragment_students_list?.visibility = View.VISIBLE
        arrayListOfStudents.getBest3Students()
        initiateUpdateAdapter()
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
        button_fragment_students_sortByName.setOnClickListener(this)
        button_fragment_students_sortByGrade.setOnClickListener(this)
        button_fragment_students_sortByRandom.setOnClickListener(this)
        FAB_fragment_students_findByQuery.setOnClickListener(this)
        FAB_fragment_students_clearField.setOnClickListener(this)
        FAB_fragment_students_goToForm.setOnClickListener(this)
    }



}