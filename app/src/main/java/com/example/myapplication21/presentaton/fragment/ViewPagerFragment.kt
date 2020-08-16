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
import com.example.myapplication21.domain.usecase.function.sort.StudentSortUseCase
import com.example.myapplication21.presentaton.adapter.ViewPagerAdapter
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import com.example.myapplication21.presentaton.utils.getBest3Students
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_viewpager.*
import javax.inject.Inject

class ViewPagerFragment : BaseFragment() {
    var rootView: View? = null
    var arrayListOfStudents: ArrayList<Student> = ArrayList()
    var adapterPosition: Int? = null
    var studentsFragmentContractView: StudentsFragmentContract.View? = null
    var sortByNameUseCase: SortByNameUseCase = SortByNameUseCase()
    var sortByMarkUseCase: SortByMarkUseCase = SortByMarkUseCase()
    var sortByRandomUseCase: SortByRandomUseCase = SortByRandomUseCase()
    var studentsFragmentPresenter: StudentsFragmentPresenter = StudentsFragmentPresenter()
    var viewPagerAdapter: ViewPagerAdapter? = null
    var student: Student? = null
    var studentFormFragment: StudentFormFragment? = null
    @Inject lateinit var studentsSortUseCase: StudentSortUseCase
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_viewpager, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerUseCaseComponent.builder().useCaseModule(UseCaseModule()).build().inject(this)

        initializeStudentsData()
        initializeViewPagerAdapter()
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
        initializeViewPagerAdapter()

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

    fun initializeViewPagerAdapter() {
        viewPagerAdapter = ViewPagerAdapter(activity?.supportFragmentManager!!, arrayListOfStudents)
        viewPager_fragment_viewpager_myViewPager?.adapter = viewPagerAdapter
        initiateUpdateAdapter()
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_fragment_viewpager_sortByName -> {
                initiateSortStudentsByName()
                initializeViewPagerAdapter()
            }
            R.id.button_fragment_viewpager_sortByMark -> {
                initiateSortStudentsByMark()
                initializeViewPagerAdapter()
            }
            R.id.button_fragment_viewpager_sortByRandom -> {
                initiateSortStudentsRandom()
                initializeViewPagerAdapter()

            }
        }
    }

    fun initializeViews() {
        if(arguments != null) {
            arguments.let {
                adapterPosition = it?.getInt("adapterPosition")
            }
        }
        initiateUpdateAdapter()
    }


    fun initializeListeners() {
        button_fragment_viewpager_sortByName.setOnClickListener(this)
        button_fragment_viewpager_sortByMark.setOnClickListener(this)
        button_fragment_viewpager_sortByRandom.setOnClickListener(this)
    }

    fun initiateUpdateAdapter() {
        viewPagerAdapter?.notifyDataSetChanged()
    }
}