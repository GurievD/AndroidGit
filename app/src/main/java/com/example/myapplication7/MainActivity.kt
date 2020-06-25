package com.example.myapplication7

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var products =
        arrayOf<String?>("Сыр", "Колбаса", "Чай", "Сахар", "Соль", "Перец", "Мука", "Масло", "Молоко", "Яйца", "Конфеты", "Печенье", "Салат", "Торт", "Пирожное", "Тесто", "Шпроты", "Сельдь", "Грибы", "Огурцы", "Кефир", "Крупа", "Картофель", "Морковь", "Чипсы", "Сок", "Пиво", "Кока-Кола", "Лимонад", "Мороженое")
    var checkedTextView: CheckedTextView? = null
    var productsList: ListView? = null
    var adapter: ListAdapter? = null
    var button: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
        assignAdapter()
    }

    fun assignAdapter() {
        productsList?.adapter = adapter
    }


    fun initializeView() {
        checkedTextView = findViewById(R.id.checkedTextView)
        productsList = findViewById(R.id.productsList)
        button = findViewById(R.id.button)
        adapter = ArrayAdapter(this, R.layout.layout_list_item, products)

    }
    fun initializeListeners() {
        productsList!!.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val checkedItems = productsList!!.checkedItemPositions
                var listItems = ""
                for (i in products.indices) {
                    if (!checkedItems[i]) {
                        listItems += products[i].toString() + "  "
                        checkedTextView?.setTextColor(ContextCompat.getColor(baseContext,R.color.colorRed))
                    }
                }
                button?.setOnClickListener {
                    checkedTextView!!.text = "Не куплены:\n$listItems"
                }
            }
    }
}