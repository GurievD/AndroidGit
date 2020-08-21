package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication21.R
import com.example.myapplication21.di.component.DaggerUseCaseComponent
import com.example.myapplication21.di.module.UseCaseModule
import com.example.myapplication21.domain.Student
import com.example.myapplication21.domain.usecase.function.sort.SortByMarkUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByNameUseCase
import com.example.myapplication21.domain.usecase.function.sort.SortByRandomUseCase
import com.example.myapplication21.domain.usecase.function.sort.StudentsSortUseCase
import com.example.myapplication21.presentaton.adapter.ViewPagerAdapter
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import com.example.myapplication21.presentaton.utils.getBest3Students
import kotlinx.android.synthetic.main.fragment_viewpager.*
import javax.inject.Inject

class ViewPagerFragment : BaseFragment(), StudentsFragmentContract.View {
    var rootView: View? = null
    var arrayListOfStudents: ArrayList<Student> = ArrayList()
    var adapterPosition: Int? = null
    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var sortByNameUseCase: SortByNameUseCase = SortByNameUseCase()
    var sortByMarkUseCase: SortByMarkUseCase = SortByMarkUseCase()
    var sortByRandomUseCase: SortByRandomUseCase = SortByRandomUseCase()
    lateinit var studentsFragmentPresenter: StudentsFragmentPresenter
    var viewPagerAdapter: ViewPagerAdapter? = null
    var student: Student? = null
    @Inject lateinit var studentsSortUseCase: StudentsSortUseCase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(R.layout.fragment_viewpager, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerUseCaseComponent.builder().useCaseModule(UseCaseModule()).build().inject(this)

        initializePresenter()
        initializeStudentsData()
        initializeAdapter()
        initializeLayoutManager()
        arrayListOfStudents.getBest3Students()
        initializeViews()
        initializeListeners()
        if(adapterPosition != null) {
            viewPager_fragment_viewpager_myViewPager?.setCurrentItem(adapterPosition!!, true)
        }
    }

    fun initializeStudentsData() {
        arrayListOfStudents.addAll(studentsFragmentPresenter.arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    fun initiateAddStudent(student: Student) {
        arrayListOfStudents.add(student)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
        initializeAdapter()

    }

    fun initiateSortStudentsByName() {
        studentsSortUseCase.initiateSortStudentsByName(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    fun initiateSortStudentsRandom() {
        studentsSortUseCase.initiateSortStudentsRandom(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    fun initiateSortStudentsByMark() {
        studentsSortUseCase.initiateSortStudentsByMark(arrayListOfStudents)
        studentsFragmentContractView?.processData(arrayListOfStudents)
        studentsFragmentContractView?.initiateUpdateAdapter()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_fragment_viewpager_sortByName -> {
                initiateSortStudentsByName()
                initializeAdapter()
            }
            R.id.button_fragment_viewpager_sortByMark -> {
                initiateSortStudentsByMark()
                initializeAdapter()
            }
            R.id.button_fragment_viewpager_sortByRandom -> {
                initiateSortStudentsRandom()
                initializeAdapter()

            }
        }
    }

    override fun initializeViews() {
        if(arguments != null) {
            arguments.let {
                adapterPosition = it?.getInt("adapterPosition")
            }
        }
    }


    override fun initializeListeners() {
        button_fragment_viewpager_sortByName.setOnClickListener(this)
        button_fragment_viewpager_sortByMark.setOnClickListener(this)
        button_fragment_viewpager_sortByRandom.setOnClickListener(this)
    }

    override fun initializePresenter() {
        studentsFragmentPresenter = StudentsFragmentPresenter(context!!)
        studentsFragmentPresenter.attach(this)
        studentsFragmentPresenter.initiateDatabaseUseCases()
    }

    override fun initializeLayoutManager() {
//        recyclerView_fragment_students_list?.layoutManager = LinearLayoutManager(context)
    }

    override fun initializeAdapter() {
        viewPagerAdapter = ViewPagerAdapter(activity?.supportFragmentManager!!, arrayListOfStudents)
        viewPager_fragment_viewpager_myViewPager?.adapter = viewPagerAdapter
        initiateUpdateAdapter()
    }

    override fun initiateUpdateAdapter() {
        viewPagerAdapter?.notifyDataSetChanged()
    }

    override fun processData(students: ArrayList<Student>) {
        this.arrayListOfStudents.clear()
        this.arrayListOfStudents.addAll(students)
    }
}