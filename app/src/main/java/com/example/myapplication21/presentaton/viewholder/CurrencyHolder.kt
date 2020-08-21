package com.example.myapplication21.presentaton.viewholder

import android.content.Context
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.domain.Currency
import com.example.myapplication21.presentaton.fragment.CurrenciesFragment
import com.example.myapplication21.presentaton.recycler.OnCurrencyItemClickListener
import kotlinx.android.synthetic.main.currency_list_item.view.*
import java.text.DecimalFormat

class CurrencyHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    var context: Context? = null
    var check = false
    @RequiresApi(Build.VERSION_CODES.M)

    fun initiateBind(currency: Currency, action: OnCurrencyItemClickListener) {
        val formattedDouble: String? = DecimalFormat("#0.00").format(currency.currencyRate)

        itemView.textView_currency_list_item_currencyTitle?.text = currency.currencyTitle

        itemView.textView_currency_list_item_currencyRate?.text = formattedDouble
        itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorLightGreen))

        itemView.setOnClickListener{
            action.onCurrencyItemClick(currency, adapterPosition)
        }
    }


}