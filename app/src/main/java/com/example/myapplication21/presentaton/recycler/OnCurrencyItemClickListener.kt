package com.example.myapplication21.presentaton.recycler

import com.example.myapplication21.domain.Currency

interface OnCurrencyItemClickListener {
    fun onCurrencyItemClick(item: Currency, adapterPosition: Int)
}