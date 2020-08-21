package com.example.myapplication21.domain.repository

import com.example.myapplication21.data.Currency
import io.reactivex.Observable

interface CurrencyDomainRepository {
    fun initiateGetCurrency() : Observable<Currency>
}