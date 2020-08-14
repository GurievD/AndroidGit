package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.adapter.CarouselAdapter
import kotlinx.android.synthetic.main.fragment_carousel.*

class CarouselFragment: BaseFragment() {
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
        initializeViews()
        initializeListeners()
    }

    fun initializeViews() {
        viewPager_fragment_carousel_mainPager.adapter = CarouselAdapter(childFragmentManager, this.context!!)
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
                    1 -> {

                    }
                    2 -> {

                    }

                }
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })
    }
}