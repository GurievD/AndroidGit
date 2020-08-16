package com.example.myapplication21.presentaton.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.domain.Student
import com.example.myapplication21.presentaton.base.BaseContract
import kotlinx.android.synthetic.main.activity_registration.*
import java.io.InputStream


class StudentsInformationFragment: BaseFragment(), BaseContract.BaseView {
    var rootView: View? = null
    var student: Student? = null
    var inputStream: InputStream? =  null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(
            R.layout.activity_registration,
            container,
            false)
        return rootView
    }

    override fun onClick(view: View?) {
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView_activity_registration_showImage?.layoutParams?.width = 100
        imageView_activity_registration_showImage?.layoutParams?.height = 100

        initializeViews()
        initializeListeners()
    }

    override fun initializeViews() {
        arguments.let {
            student = it?.getParcelable("StudentObject")
        }
        openAssets("noavatar.png", student?.studentAvatar, imageView_activity_registration_showImage)
//        val drawableCreateFromStream = Drawable.createFromStream(inputStream, null)

        textView_activity_registration_showNameAndLastName.text = "${student?.studentName} ${student?.studentLastName}"
        textView_activity_registration_showDescription.text = "${student?.studentDescription}"
        textView_activity_registration_showSubject.text = "Группа: ${student?.studentGroup}-й класс"
//        if (student?.studentAvatar != null) {
//            imageView_activity_registration_showImage.setImageBitmap(student?.studentAvatar)
//        }
//        else {
//            imageView_activity_registration_showImage.setImageDrawable(drawableCreateFromStream)
//        }
        textView_activity_registration_showMark.text = "Средняя оценка: ${student?.studentMark}"
    }

    override fun initializeListeners() {

    }
}