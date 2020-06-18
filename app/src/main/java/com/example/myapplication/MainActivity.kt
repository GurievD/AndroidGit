package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.GridView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var students: ArrayList<String> = arrayListOf("Вадим", "Эльдар", "Суюн", "Дастан", "Болат", "Денис", "Саша", "Оля", "Коля", "Наташа", "Слава", "Карина", "Регина", "Илона", "Моника")
    var button: Button? = null
    var button2: Button? = null
    var adapter: ArrayAdapter<String>? = null
    var studentsArray: GridView? = null
    var textview: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeView()
        initializeListeners()
        assignAdapter()
    }

    fun assignAdapter() {
        studentsArray?.adapter = adapter
    }

    fun initializeView() {
        button = findViewById(R.id.button_activity_students_sort_byname)
        button2 = findViewById(R.id.button_activity_students_sort_random)
        textview = findViewById(R.id.textview_activity_students_description)
        adapter = ArrayAdapter(this, R.layout.layout_list_item, students)
        studentsArray = findViewById(R.id.gridview)
    }

    fun initializeListeners() {
        button?.setOnClickListener {
            textview?.text = getString(R.string.sorted_byname)

            Log.i("TAG", "ТЕСТ!")
            this.assignAdapter()

            students.sort();
        }
        button2?.setOnClickListener {
            textview?.text = getString(R.string.sorted_random)

            Log.i("TAG", "ПРИВЕТ МИР!")
            this.assignAdapter()

            students.shuffle();
        }
    }
}