package com.example.myapplication21.presentaton.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication21.R
import com.example.myapplication21.data.Currency
import com.example.myapplication21.data.api.APIConnection
import com.example.myapplication21.di.component.DaggerDatabaseComponent
import com.example.myapplication21.di.module.DatabaseModule
import com.example.myapplication21.domain.Student
import com.example.myapplication21.domain.usecase.function.db.DatabaseUseCase
import com.example.myapplication21.presentaton.adapter.CarouselAdapter
import com.example.myapplication21.presentaton.adapter.StudentsAdapter
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnStudentItemClickListener
import com.example.myapplication21.presentaton.utils.getBest3Students
import kotlinx.android.synthetic.main.fragment_students.*
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class StudentsFragment : BaseFragment(), StudentsFragmentContract.View, OnStudentItemClickListener {
    var studentsAdapter: StudentsAdapter? = null

    var arrayListOfStudents: ArrayList<Student> = ArrayList()
    var rootView: View? = null
    var viewPagerFragment: ViewPagerFragment? = null
    var carouselAdapter: CarouselAdapter? = null
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

    @SuppressLint("LongLogTag")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        studentsFragmentPresenter.initializeData()
        initializeViews()
        initializeListeners()
    }

    fun setArguments(studentObject: Student): StudentsInformationFragment {
        val studentsInformationFragment = StudentsInformationFragment()
        val bundleOfArguments = Bundle()
        bundleOfArguments.putParcelable("StudentObject", studentObject)
        studentsInformationFragment.arguments = bundleOfArguments

        return studentsInformationFragment
    }

    override fun onClick(view: View?) {
            when (view?.id) {
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
                R.id.button_fragment_students_changeView -> {
                    baseTransaction(R.id.relativeLayout_activity_students_fragmentContainer, ViewPagerFragment(), "ChangeView")
                }
            }
    }


    override fun onStudentItemClick(item: Student, adapterPosition: Int) {
        val studentsInformationFragment = baseArguments(StudentsInformationFragment(), studentsAdapter?.arrayListOfStudents!![adapterPosition])
        baseTransaction(R.id.relativeLayout_activity_students_fragmentContainer, studentsInformationFragment, "MoreAboutStudent")

    }

    override fun onStudentItemClick2(item: Student, adapterPosition: Int) {
        val viewPagerFragment = baseArguments(ViewPagerFragment(), null, adapterPosition)
        baseTransaction(R.id.relativeLayout_activity_students_fragmentContainer, viewPagerFragment, "ViewPager")
    }

    override fun initializePresenter() {
        studentsFragmentPresenter = StudentsFragmentPresenter(context!!)
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
        studentsAdapter = StudentsAdapter(context, arrayListOfStudents, this)

        recyclerView_fragment_students_list?.adapter = studentsAdapter
    }

    override fun processData(students: ArrayList<Student>) {
        this.arrayListOfStudents.clear()
        this.arrayListOfStudents.addAll(students)
    }

    override fun initiateUpdateAdapter() {
        studentsAdapter?.notifyDataSetChanged()

    }

    override fun initializeListeners() {
        FAB_fragment_students_findByQuery.setOnClickListener(this)
        FAB_fragment_students_clearField.setOnClickListener(this)
        FAB_fragment_students_goToForm.setOnClickListener(this)
        button_fragment_students_getBack.setOnClickListener(this)
        button_fragment_students_changeView.setOnClickListener(this)
    }
}