package com.example.practicework62

import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var imageURI: Uri? = null
    var buttonToCapturePhoto: Button? = null
    var imageViewToShowPhoto: ImageView? = null
    var contentValues: ContentValues? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        //Я никак не могу понять, почему у меня нет диалогового окна,
        // где можно разрешить/отказать отсылать SMS, делать снимки, и т.д.

        //Моя версия - Lollipop 5.1 (API 22), и эмулятор даже не спрашивает у меня разрешения,
        // хочу ли я разрешить отсылать SMS или делать снимки

        //Эмулятор по умолчанию сам всё разрешает,
        // лишь бы только была прописана нужная строчка uses-permission в Манифесте

        //Разрешение в настройках тоже никак отнять не могу, уже пробовал, нет такой опции

        //Странно, почему так?

        //ВАЖНО: Попробуйте запустить программу на Lollipop версии,
        // проверьте, будет ли оно так же работать как у меня, или будет спрашивать разрешение?
        //Если да, возможно - проблема у меня

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        buttonToCapturePhoto = findViewById(R.id.button_activity_main_captureAction)
        imageViewToShowPhoto = findViewById(R.id.imageView_activity_main_showCapturedPhoto)
        contentValues = ContentValues()
    }

    fun initializeListeners() {
        buttonToCapturePhoto?.setOnClickListener {
            val requestCode = 123
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            imageURI = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues)
            cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageURI)
            startActivityForResult(cameraIntent, requestCode)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode  == Activity.RESULT_OK) {
            imageViewToShowPhoto?.setImageURI(imageURI)
            //Изначально я выводил фото в ImageView проще:
            //
            //  val bitmap = data?.extras?.get("data") as Bitmap?
            //  imageViewToShowPhoto?.setImageBitmap(bitmap)
            //
            // но разрешение фото было слишком низким, потому что "data" используется для иконок

            // Меня это не устроило, поэтому я решил разобраться как можно сделать фото
            // и вывести его в высоком разрешении в ImageView
        }
    }
}