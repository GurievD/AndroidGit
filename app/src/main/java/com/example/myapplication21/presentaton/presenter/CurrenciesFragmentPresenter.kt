package com.example.myapplication21.presentaton.presenter

import android.content.Context
import com.example.myapplication21.data.Currency
import com.example.myapplication21.domain.usecase.function.currencies.CurrenciesUseCase
import com.example.myapplication21.presentaton.contract.CurrenciesFragmentContract

class CurrenciesFragmentPresenter(context: Context) : CurrenciesFragmentContract.Presenter {
    var currenciesFragmentContractView: CurrenciesFragmentContract.View? = null
    var context: Context? = context
    var arrayListOfCurrencies: ArrayList<com.example.myapplication21.domain.Currency> = ArrayList()
    var currenciesUseCase: CurrenciesUseCase = CurrenciesUseCase()

    override fun initializeData(currency: Currency) {
        arrayListOfCurrencies = currenciesUseCase.initiateGetCurrencyList(currency)
        currenciesFragmentContractView?.processData(arrayListOfCurrencies)
        currenciesFragmentContractView?.initiateUpdateAdapter()
    }

    override fun attach(view: CurrenciesFragmentContract.View) {
        this.currenciesFragmentContractView = view
    }

    override fun onStop() {
        currenciesFragmentContractView = null
    }
}