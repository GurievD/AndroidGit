package com.example.myapplication21.helpers

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.provider.MediaStore
import androidx.annotation.RequiresApi
import com.example.myapplication21.presentaton.contract.CameraHelperContract

class CameraHelper(var activityContext: Activity): CameraHelperContract {
    var REQUEST_CODE = 123
    @RequiresApi(Build.VERSION_CODES.M)
    override fun initiateCamera() {
        if(activityContext.checkSelfPermission(android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            activityContext.startActivityForResult(cameraIntent, REQUEST_CODE)
        }
        else {
            activityContext.requestPermissions(arrayOf(android.Manifest.permission.CAMERA), REQUEST_CODE)
        }
    }
}