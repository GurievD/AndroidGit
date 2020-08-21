package com.example.myapplication21.presentaton.adapter

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.domain.Currency
import com.example.myapplication21.presentaton.presenter.CurrenciesFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnCurrencyItemClickListener
import com.example.myapplication21.presentaton.viewholder.CurrencyHolder

class CurrencyAdapter(context: Context, var arrayListOfCurrencies: ArrayList<Currency>, presenter: CurrenciesFragmentPresenter, var onCurrencyItemClickListener: OnCurrencyItemClickListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var context: Context? = context

    var currenciesFragmentPresenter: CurrenciesFragmentPresenter? = presenter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflateView = LayoutInflater.from(context!!).inflate(R.layout.currency_list_item, parent, false)
        return CurrencyHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return arrayListOfCurrencies.size
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as CurrencyHolder).initiateBind(arrayListOfCurrencies[position], onCurrencyItemClickListener)
    }
}