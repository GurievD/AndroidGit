package com.example.myapplication21.presentaton.fragment

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.myapplication21.domain.Student
import com.example.myapplication21.domain.usecase.function.context.MyContext
import com.example.myapplication21.domain.usecase.function.sort.StudentSortUseCase
import com.example.myapplication21.presentaton.contract.StudentsFragmentContract
import kotlinx.android.synthetic.main.fragment_viewpager.*
import java.io.InputStream
import javax.inject.Inject

abstract class BaseFragment: Fragment(), View.OnClickListener {

    fun baseTransaction(container:Int, fragment: Fragment, tag: String) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentManager?.executePendingTransactions()
        fragmentTransaction?.add(container, fragment, tag)
        fragmentTransaction?.hide(this)
        fragmentTransaction?.addToBackStack("name")
        fragmentTransaction?.commit()
    }
    fun baseArguments(fragment: Fragment, studentObject: Student? = null, adapterPosition: Int? = null): Fragment {
        val bundleOfArguments = Bundle()
        bundleOfArguments.putParcelable("StudentObject", studentObject)
        if (adapterPosition != null) {
            bundleOfArguments.putInt("adapterPosition", adapterPosition)
        }
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