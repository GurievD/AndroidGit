package com.example.myapplication7

import android.os.Bundle
import android.widget.*
import android.widget.AdapterView.OnItemClickListener
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    var arrayOfProducts =
        arrayOf<String?>("Сыр", "Колбаса", "Чай", "Сахар", "Соль", "Перец", "Мука", "Масло", "Молоко", "Яйца", "Конфеты", "Печенье", "Салат", "Торт", "Пирожное", "Тесто", "Шпроты", "Сельдь", "Грибы", "Огурцы", "Кефир", "Крупа", "Картофель", "Морковь", "Чипсы", "Сок", "Пиво", "Кока-Кола", "Лимонад", "Мороженое")
    var checkedTextViewChecked: CheckedTextView? = null
    var listViewProductsList: ListView? = null
    var listAdapter: ListAdapter? = null
    var buttonCheck: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
        assignAdapter()
    }

    fun assignAdapter() {
        listViewProductsList?.adapter = listAdapter
    }


    fun initializeView() {
        checkedTextViewChecked = findViewById(R.id.checkedTextView_activity_main_checked)
        listViewProductsList = findViewById(R.id.listView_activity_main_productsList)
        buttonCheck = findViewById(R.id.button_activity_main_check)
        listAdapter = ArrayAdapter(this, R.layout.layout_list_item, arrayOfProducts)

    }
    fun initializeListeners() {
        listViewProductsList!!.onItemClickListener =
            OnItemClickListener { parent, view, position, id ->
                val checkedItemPositions = listViewProductsList!!.checkedItemPositions
                var listOfUncheckedItems = ""
                for (i in arrayOfProducts.indices) {
                    if (!checkedItemPositions[i]) {
                        listOfUncheckedItems += arrayOfProducts[i].toString() + "  "
                        checkedTextViewChecked?.setTextColor(ContextCompat.getColor(baseContext,R.color.colorRed))
                    }
                }
                buttonCheck?.setOnClickListener {
                    checkedTextViewChecked!!.text = "Не куплены:\n$listOfUncheckedItems"
                }
            }
    }
}