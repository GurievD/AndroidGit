package com.example.myapplication21.domain.usecase.function.currencies

import com.example.myapplication21.data.Currency

class CurrenciesUseCase {
    fun initiateGetCurrencyList(currency: Currency): ArrayList<com.example.myapplication21.domain.Currency> {

        return arrayListOf(
            com.example.myapplication21.domain.Currency("CAD", currency.getRates()?.cad!!),
            com.example.myapplication21.domain.Currency("HKD", currency.getRates()?.hkd!!),
            com.example.myapplication21.domain.Currency("ISK", currency.getRates()?.isk!!),
            com.example.myapplication21.domain.Currency("PHP", currency.getRates()?.php!!),
            com.example.myapplication21.domain.Currency("DKK", currency.getRates()?.dkk!!),
            com.example.myapplication21.domain.Currency("HUF", currency.getRates()?.huf!!),
            com.example.myapplication21.domain.Currency("CZK", currency.getRates()?.czk!!),
            com.example.myapplication21.domain.Currency("AUD", currency.getRates()?.aud!!),
            com.example.myapplication21.domain.Currency("RON", currency.getRates()?.ron!!),
            com.example.myapplication21.domain.Currency("SEK", currency.getRates()?.sek!!),
            com.example.myapplication21.domain.Currency("IDR", currency.getRates()?.idr!!),
            com.example.myapplication21.domain.Currency("INR", currency.getRates()?.inr!!),
            com.example.myapplication21.domain.Currency("BRL", currency.getRates()?.brl!!),
            com.example.myapplication21.domain.Currency("RUB", currency.getRates()?.rub!!),
            com.example.myapplication21.domain.Currency("HRK", currency.getRates()?.hrk!!),
            com.example.myapplication21.domain.Currency("JPY", currency.getRates()?.jpy!!),
            com.example.myapplication21.domain.Currency("THB", currency.getRates()?.thb!!),
            com.example.myapplication21.domain.Currency("CHF", currency.getRates()?.chf!!),
            com.example.myapplication21.domain.Currency("SGD", currency.getRates()?.sgd!!),
            com.example.myapplication21.domain.Currency("PLN", currency.getRates()?.pln!!),
            com.example.myapplication21.domain.Currency("BGN", currency.getRates()?.bgn!!),
            com.example.myapplication21.domain.Currency("TRY", currency.getRates()?.`try`!!),
            com.example.myapplication21.domain.Currency("CNY", currency.getRates()?.cny!!),
            com.example.myapplication21.domain.Currency("NOK", currency.getRates()?.nok!!),
            com.example.myapplication21.domain.Currency("NZD", currency.getRates()?.nzd!!),
            com.example.myapplication21.domain.Currency("ZAR", currency.getRates()?.zar!!),
            com.example.myapplication21.domain.Currency("USD", currency.getRates()?.usd!!),
            com.example.myapplication21.domain.Currency("MXN", currency.getRates()?.mxn!!),
            com.example.myapplication21.domain.Currency("ILS", currency.getRates()?.ils!!),
            com.example.myapplication21.domain.Currency("GBP", currency.getRates()?.gbp!!),
            com.example.myapplication21.domain.Currency("KRW", currency.getRates()?.krw!!),
            com.example.myapplication21.domain.Currency("MYR", currency.getRates()?.myr!!)
        )
    }
}