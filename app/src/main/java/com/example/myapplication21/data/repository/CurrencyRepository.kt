package com.example.myapplication21.data.repository

import com.example.myapplication21.data.Currency
import com.example.myapplication21.data.api.APIImplementation
import com.example.myapplication21.domain.repository.CurrencyDomainRepository
import com.example.myapplication21.presentaton.presenter.CurrenciesFragmentPresenter
import io.reactivex.Observable

class CurrencyRepository() : CurrencyDomainRepository {

    var apiImplementation: APIImplementation = APIImplementation()
    var currenciesFragmentPresenter: CurrenciesFragmentPresenter? = null
    override fun initiateGetCurrency(): Observable<Currency> {
        return apiImplementation.initiateGetCurrencies()
            .map { response ->
                if(response.isSuccessful){
                    response.body()
                }else{
                    throw Exception()
                }
            }
    }
}