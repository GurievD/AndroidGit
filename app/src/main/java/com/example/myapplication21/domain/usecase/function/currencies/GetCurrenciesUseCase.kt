package com.example.myapplication21.domain.usecase.function.currencies

import com.example.myapplication21.data.Currency
import com.example.myapplication21.data.repository.CurrencyRepository
import com.example.myapplication21.domain.usecase.function.currencies.base.BaseNetworkUseCase
import com.example.myapplication21.domain.repository.CurrencyDomainRepository
import io.reactivex.Observable

class GetCurrenciesUseCase() : BaseNetworkUseCase<Currency>() {

    var currencyDomainRepository: CurrencyDomainRepository = CurrencyRepository()

    override fun initiateCreateObservable(): Observable<Currency> {
        return currencyDomainRepository.initiateGetCurrency()
    }
}