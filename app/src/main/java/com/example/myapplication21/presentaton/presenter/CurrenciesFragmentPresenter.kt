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
import com.example.myapplication21.domain.usecase.function.currencies.GetCurrenciesUseCase
import com.example.myapplication21.presentaton.contract.CurrenciesFragmentContract
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class CurrenciesFragmentPresenter(context: Context) : CurrenciesFragmentContract.Presenter {
    var currenciesFragmentContractView: CurrenciesFragmentContract.View? = null
    var context: Context? = context
    var arrayListOfCurrencies: ArrayList<com.example.myapplication21.domain.Currency> = ArrayList()
    var currenciesUseCase: CurrenciesUseCase = CurrenciesUseCase()
    var currencyData: com.example.myapplication21.domain.Currency? = null
    var getCurrenciesUseCase: GetCurrenciesUseCase

    @Inject
    lateinit var api: APIImplementation

    init {
        DaggerNetworkComponent.builder().networkModule(NetworkModule()).build().inject(this)
        this.getCurrenciesUseCase = GetCurrenciesUseCase()

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

    fun initiateRequestCurrencies() {
        getCurrenciesUseCase.execute(CurrenciesObserver())
    }

    inner class CurrenciesObserver : DisposableObserver<Currency>(){
        override fun onComplete() {
            Log.d("DATA", "onComplete")
        }

        override fun onNext(currency: Currency) {
            initializeData(currency)
            Log.d("DATA", "onNext")

        }

        override fun onError(e: Throwable) {
            Log.d("DATA", "onError")
        }
    }
}