package com.example.myapplication21.presentaton.fragment

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.myapplication21.data.Student
import com.example.myapplication21.data.Subject
import java.io.InputStream

abstract class BaseFragment: Fragment(), View.OnClickListener {
    fun baseTransaction(container:Int, fragment: Fragment, tag: String) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentManager?.executePendingTransactions()
        fragmentTransaction?.add(container, fragment, tag)
        fragmentTransaction?.hide(this)
        fragmentTransaction?.addToBackStack("name")
        fragmentTransaction?.commit()
    }
    fun baseArguments(fragment: Fragment, studentObject: Student? = null, studentSubject: Subject? = null, subject: Subject? = null): Fragment {
        val bundleOfArguments = Bundle()
        bundleOfArguments.putParcelable("StudentObject", studentObject)
        bundleOfArguments.putParcelable("StudentSubject", studentSubject)
        bundleOfArguments.putParcelable("Subject", subject)
        fragment.arguments = bundleOfArguments
        return fragment
    }
    fun openAssets(fileName: String, bitmap: Bitmap?, imageView: ImageView): InputStream? {
        val inputStream: InputStream? = context?.assets?.open(fileName)
        val drawableCreateFromStream = Drawable.createFromStream(inputStream, null)
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap)
        }
        else {
            imageView.setImageDrawable(drawableCreateFromStream)
        }

        return inputStream
    }
}