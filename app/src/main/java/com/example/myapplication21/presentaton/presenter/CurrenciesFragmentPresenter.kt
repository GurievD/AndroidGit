package com.example.myapplication21.presentaton.presenter

import android.content.Context
import android.util.Log
import com.example.myapplication21.data.Currency
import com.example.myapplication21.data.api.APIImplementation
import com.example.myapplication21.di.component.DaggerDatabaseComponent
import com.example.myapplication21.di.component.DaggerNetworkComponent
import com.example.myapplication21.di.module.DatabaseModule
import com.example.myapplication21.di.module.NetworkModule
import com.example.myapplication21.domain.usecase.function.currencies.CurrenciesUseCase
import com.example.myapplication21.presentaton.contract.CurrenciesFragmentContract
import javax.inject.Inject

class CurrenciesFragmentPresenter(context: Context) : CurrenciesFragmentContract.Presenter {
    var currenciesFragmentContractView: CurrenciesFragmentContract.View? = null
    var context: Context? = context
    var arrayListOfCurrencies: ArrayList<com.example.myapplication21.domain.Currency> = ArrayList()
    var currenciesUseCase: CurrenciesUseCase = CurrenciesUseCase()
    var currencyData: com.example.myapplication21.domain.Currency? = null
    @Inject
    lateinit var api: APIImplementation

    init {
        DaggerNetworkComponent.builder().networkModule(NetworkModule()).build().inject(this)
    }

    override fun initializeData(currency: Currency) {
        Log.d("BASE", "${api.getBaseCurrency(currency.getBase().toString()).request()}")
        Log.d("RATES", "${api.getBaseCurrency(currency.getRates().toString()).request()}")

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