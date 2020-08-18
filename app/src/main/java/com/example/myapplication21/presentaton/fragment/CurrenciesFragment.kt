package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication21.R
import com.example.myapplication21.data.api.APIConnection
import com.example.myapplication21.data.api.APIImplementation
import com.example.myapplication21.domain.Currency
import com.example.myapplication21.presentaton.adapter.CurrencyAdapter
import com.example.myapplication21.presentaton.contract.CurrenciesFragmentContract
import com.example.myapplication21.presentaton.presenter.CurrenciesFragmentPresenter
import com.example.myapplication21.presentaton.recycler.OnCurrencyItemClickListener
import kotlinx.android.synthetic.main.fragment_currencies.*
import retrofit2.Call
import retrofit2.Response

class CurrenciesFragment: Fragment(), CurrenciesFragmentContract.View, View.OnClickListener, OnCurrencyItemClickListener {
    var rootView: View? = null
    lateinit var currenciesFragmentContractPresenter: CurrenciesFragmentContract.Presenter
    var currencyAdapter: CurrencyAdapter? = null
    val arrayListOfCurrencies: ArrayList<Currency> = ArrayList()
    var currency: com.example.myapplication21.data.Currency? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.fragment_currencies,
            container,
            false
        )

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializePresenter()
        initializeLayoutManager()
        initializeAdapter()
        initializeViews()
        initializeListeners()
    }

    override fun initializeListeners() {
    }

    override fun onClick(v: View?) {
    }

    override fun initializePresenter() {
        currenciesFragmentContractPresenter = CurrenciesFragmentPresenter(context!!)
        currenciesFragmentContractPresenter.attach(this)
    }

    override fun initializeLayoutManager() {
        recyclerView_fragment_currencies?.layoutManager = LinearLayoutManager(context!!)
    }

    override fun initializeAdapter() {
        currencyAdapter = CurrencyAdapter(context!!, arrayListOfCurrencies, currenciesFragmentContractPresenter as CurrenciesFragmentPresenter, this)
        recyclerView_fragment_currencies?.adapter = currencyAdapter
    }

    override fun initiateUpdateAdapter() {
        currencyAdapter?.notifyDataSetChanged()
    }

    override fun processData(currencies: ArrayList<Currency>) {
        this.arrayListOfCurrencies.clear()
        this.arrayListOfCurrencies.addAll(currencies)
    }

    override fun initializeViews() {
        val retrofit = APIImplementation().getLatestCurrencies()
        retrofit.enqueue(object : retrofit2.Callback<com.example.myapplication21.data.Currency> {
            override fun onFailure(call: Call<com.example.myapplication21.data.Currency>, t: Throwable) {
                Log.e("TAG", "Ошибка! Не удалось получить доступ к валютам!")
            }

            override fun onResponse(call: Call<com.example.myapplication21.data.Currency>, response: Response<com.example.myapplication21.data.Currency>) {
                currency = response.body()
                currenciesFragmentContractPresenter.initializeData(currency!!)
            }
        })
    }

    override fun onCurrencyItemClick(item: Currency, adapterPosition: Int) {

        val retrofit = APIImplementation().getBaseCurrency(arrayListOfCurrencies[adapterPosition].currencyTitle)
        retrofit.enqueue(object : retrofit2.Callback<com.example.myapplication21.data.Currency> {
            override fun onFailure(call: Call<com.example.myapplication21.data.Currency>, t: Throwable) {
                Log.e("TAG", "Ошибка! Не удалось получить доступ к валютам!")
            }

            override fun onResponse(call: Call<com.example.myapplication21.data.Currency>, response: Response<com.example.myapplication21.data.Currency>) {
                currency = response.body()
                currenciesFragmentContractPresenter.initializeData(currency!!)
                val remove = arrayListOfCurrencies.removeAt(adapterPosition)
                arrayListOfCurrencies.add(0, remove)
                initiateUpdateAdapter()
            }
        })
    }
}