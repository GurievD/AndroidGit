package com.example.myapplication21.presentaton.contract

import com.example.myapplication21.domain.Currency
import com.example.myapplication21.presentaton.base.BaseContract

interface CurrenciesFragmentContract {
    interface View: BaseContract.BaseView{
        fun initializePresenter()

        fun initializeLayoutManager()

        fun initializeAdapter()

        fun initiateUpdateAdapter()

        fun processData(currencies: ArrayList<Currency>)
    }

    interface Presenter : BaseContract.BasePresenter<View>{
        fun initializeData(currency: com.example.myapplication21.data.Currency)
    }
}