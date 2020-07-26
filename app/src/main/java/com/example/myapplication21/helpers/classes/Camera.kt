package com.example.myapplication21.helpers.classes

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R
import com.example.myapplication21.helpers.CameraHelper
import kotlinx.android.synthetic.main.camera.*

class Camera: AppCompatActivity() {

    var cameraHelper: CameraHelper = CameraHelper(this)
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.camera)
        initializeListeners()
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun initializeListeners() {
        button_camera_takePicture.setOnClickListener {
            cameraHelper.initiateCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode  == Activity.RESULT_OK) {
            val bitmap = data?.extras?.get("data") as Bitmap?
            imageView_camera_showCapturedPhoto.setImageBitmap(bitmap)
        }
    }
}