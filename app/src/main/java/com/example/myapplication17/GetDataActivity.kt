package com.example.myapplication17

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class GetDataActivity : AppCompatActivity() {
    var textViewToShowName: TextView? = null
    var textViewToShowLastName: TextView? = null
    //Суюн, у вас в задании видимо опечатка, там сказано создать 2 вьюшки EditText для ОТОБРАЖЕНИЯ данных
    //Наверное, вы имели в виду TextView, потому что я не вижу смысла в возвращении на первую страницу
    //чтобы заполнить данные, если мы можем изменять содержимое EditText на второй странице

    //Надеюсь, это не критично
    var imageViewToGetPicture: ImageView? = null
    var getPicture: Int? = null
    var buttonToGetBack: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.my_data)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        textViewToShowName = findViewById(R.id.textView_activity_main_showName)
        textViewToShowLastName = findViewById(R.id.textView_activity_main_showLastName)
        imageViewToGetPicture = findViewById(R.id.imageView_activity_main_getPicture)
        buttonToGetBack = findViewById(R.id.button_activity_main_intentGetBack)
    }

    fun initializeListeners() {
        val getName = intent.getStringExtra("name")
        val getLastName = intent.getStringExtra("lastname")
        getPicture = intent.extras?.getInt("picture")
        imageViewToGetPicture?.setImageResource(getPicture!!)


        textViewToShowName?.text = getString(R.string.get_data_textView_Name, getName)
        textViewToShowLastName?.text = getString(R.string.get_data_textView_lastName, getLastName)

        buttonToGetBack?.setOnClickListener {
            //Тут я долго думал, нужно ли мне вызывать startActivity или finish
            //Я всё же решил выбрать finish, потому что пользователь может захотеть отредактировать поле
            //А при вызове startActivity все поля будут пустыми, и введённые данные не сохранятся
            finish()
        }
    }
}