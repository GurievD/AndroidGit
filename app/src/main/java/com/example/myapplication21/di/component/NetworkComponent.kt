package com.example.myapplication21.di.component

import com.example.myapplication21.di.module.NetworkModule
import com.example.myapplication21.presentaton.presenter.CurrenciesFragmentPresenter
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(currenciesFragmentPresenter: CurrenciesFragmentPresenter)
}