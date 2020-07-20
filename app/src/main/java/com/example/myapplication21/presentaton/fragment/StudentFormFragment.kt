package com.example.myapplication21.presentaton.fragment

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import com.example.myapplication21.R
import com.example.myapplication21.data.Student
import com.example.myapplication21.presentaton.base.BaseContract
import kotlinx.android.synthetic.main.student_form.*


class StudentFormFragment: Fragment(), BaseContract.BaseView, View.OnClickListener {
    var rootView: View? = null
    var studentName: EditText? = null
    var studentLastName: EditText? = null
    var studentDescription: EditText? = null
    var studentMark: EditText? = null
    var studentGroup: EditText? = null
    var imageURI: Uri? = null
    var bitmap: Bitmap? = null

    var reqCode = 123
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.student_form,
            container,
            false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeViews()
        initializeListeners()
    }

    override fun initializeViews() {
        studentName = editText_student_form_inputName
        studentLastName = editText_student_form_inputLastName
        studentDescription = editText_student_form_inputDescription
        studentGroup = editText_student_form_inputGroup
        studentMark = editText_student_form_inputMark
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.button_student_form_confirmAddNewStudent -> {

                val editTextName = studentName?.text.toString()
                val editTextLastName = studentLastName?.text.toString()
                val editTextDescription = studentDescription?.text.toString()
                val editTextGroup = studentGroup?.text.toString()
                val editTextMark = studentMark?.text.toString()

                if (editTextName.isNotBlank() && editTextLastName.isNotBlank() && editTextDescription.isNotBlank() && editTextGroup.isNotBlank() && editTextMark.isNotBlank())
                {
                    bitmap = imageView_student_form_showStudentPhoto.drawable.toBitmap()
                    when {
                        editTextGroup.toInt() in 1..11 && editTextMark.toFloat() in 1.0..12.0 -> {
                            val studentObject = Student(editTextName, editTextLastName, editTextDescription, bitmap, editTextGroup.toInt(), editTextMark.toFloat())
                            val findStudentsFragment = fragmentManager?.findFragmentByTag("StudentsFragment") as StudentsFragment

                            findStudentsFragment.studentsFragmentPresenter.initiateAddStudent(studentObject)
                            fragmentManager?.popBackStack()

                            findStudentsFragment.studentsFragmentPresenter.initiateSortStudentsByName()
                        }
                        else -> {
                            textView_student_form_showError.text = resources.getString(R.string.student_form_must_be_in_range)
                            textView_student_form_showError.setTextColor(ContextCompat.getColor(context?.applicationContext!!, R.color.colorRed))
                        }
                    }
                }
                else {
                    textView_student_form_showError.text = resources.getString(R.string.student_form_fieldBlank)
                    textView_student_form_showError.setTextColor(ContextCompat.getColor(context?.applicationContext!!, R.color.colorRed))
                }
            }
            R.id.button_student_form_addStudentPhoto -> {
                if (ActivityCompat.checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    reqCode = 456
                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), reqCode)
                } else {
                    val intentActionPick = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(intentActionPick, reqCode)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == reqCode) {
                imageURI = data?.data
                imageView_student_form_showStudentPhoto?.setImageURI(imageURI)
            }
        }
    }

    override fun initializeListeners() {
        button_student_form_confirmAddNewStudent.setOnClickListener(this)
        button_student_form_addStudentPhoto.setOnClickListener(this)
    }
}