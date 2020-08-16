package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.ViewPager
import com.example.myapplication21.R
import com.example.myapplication21.di.component.DaggerContextComponent
import com.example.myapplication21.di.module.ContextModule
import com.example.myapplication21.domain.usecase.function.context.MyContext
import com.example.myapplication21.presentaton.adapter.CarouselAdapter
import com.example.myapplication21.presentaton.presenter.StudentsFragmentPresenter
import kotlinx.android.synthetic.main.activity_registration.*
import kotlinx.android.synthetic.main.fragment_carousel.*
import kotlinx.android.synthetic.main.fragment_mainpage.*
import kotlinx.android.synthetic.main.fragment_students.*
import javax.inject.Inject


class CarouselFragment: BaseFragment() {
    @Inject
    lateinit var myContext: MyContext

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_carousel, container, false)
    }

    override fun onClick(view: View?) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerContextComponent.builder().contextModule(ContextModule(this)).build().injectCarouselFragment(this)

        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        viewPager_fragment_carousel_mainPager.adapter = CarouselAdapter(childFragmentManager, myContext.returnContext(context!!)!!)
        tabLayout_fragment_carousel_tabs.setupWithViewPager(viewPager_fragment_carousel_mainPager)
    }

    fun initializeListeners() {
        viewPager_fragment_carousel_mainPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {

                    }
                    1 -> {
                        gridLayout_fragment_students_gridForPanel.visibility = View.INVISIBLE
                    }
                    2 -> {

                    }

                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}