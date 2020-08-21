package com.example.myapplication21.data.api

import com.example.myapplication21.data.Currency
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response

class APIImplementation() : APIInterface {
    var api = APIConnection().initializeAPI()


    override fun getLatestCurrencies(): Call<Currency> {
        return api.getLatestCurrencies()
    }

    override fun getBaseCurrency(base: String): Call<Currency> {
        return api.getBaseCurrency(base)
    }

    override fun initiateGetCurrencies(): Observable<Response<Currency>> {
        return api.initiateGetCurrencies()
    }

    override fun getObservableBaseCurrency(base: String): Observable<Response<Currency>> {
        return api.getObservableBaseCurrency(base)
    }
}