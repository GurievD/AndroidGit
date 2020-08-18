package com.example.myapplication21.data.api

import com.example.myapplication21.data.Currency
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("latest")
    fun getLatestCurrencies(): Call<Currency>

    @GET("latest")
    fun getBaseCurrency(@Query("base") base: String): Call<Currency>
}