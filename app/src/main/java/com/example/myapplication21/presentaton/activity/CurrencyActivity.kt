package com.example.myapplication21.presentaton.activity

import android.content.Context
import android.os.Bundle
import com.example.myapplication21.R
import com.example.myapplication21.presentaton.fragment.CurrenciesFragment
import com.example.myapplication21.presentaton.fragment.StudentsFragment

class CurrencyActivity: BaseActivity() {
    var context: Context? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currencies)
        initializeDefaultFragment(CurrenciesFragment(), R.id.relativeLayout_activity_currencies_fragmentContainer, "CurrenciesFragment")

    }

    override fun instanceOfHostActivity(): BaseActivity {
        return this
    }


}