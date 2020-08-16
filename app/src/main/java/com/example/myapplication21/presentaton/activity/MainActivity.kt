package com.example.myapplication21.presentaton.activity

import android.os.Bundle
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.CarouselFragment


class MainActivity : BaseActivity() {
    var carouselFragment = CarouselFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            initializeDefaultFragment(carouselFragment, R.id.main_container, "CarouselFragment")
        }
        else {
            carouselFragment = supportFragmentManager.fragments[0] as CarouselFragment
        }

    }



    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }
}