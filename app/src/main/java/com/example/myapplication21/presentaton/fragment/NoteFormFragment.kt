package com.example.myapplication21.presentaton.fragment

import android.Manifest
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.EditText
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap
import com.example.myapplication21.R
import com.example.myapplication21.domain.Note
import com.example.myapplication21.presentaton.base.BaseContract
import kotlinx.android.synthetic.main.note_form.*
import java.time.LocalDate

class NoteFormFragment: BaseFragment(), BaseContract.BaseView, DatePickerDialog.OnDateSetListener {
    var rootView: View? = null
    var noteTitle: EditText? = null
    var noteDescription: EditText? = null
    var noteExpirationDate: EditText? = null
    var imageURI: Uri? = null
    var bitmap: Bitmap? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = LayoutInflater.from(context).inflate(
            R.layout.note_form,
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
        noteTitle = editText_note_form_inputTitle
        noteDescription = editText_note_form_inputDescription
        noteExpirationDate = editText_note_form_inputExpirationDate
    }

    override fun onClick(view: View?) {
        val editTextTitle = noteTitle?.text.toString()
        val editTextDescription = noteDescription?.text.toString()
        val editTextExpirationDate = noteExpirationDate?.text.toString()
        when (view?.id) {
            R.id.button_note_form_confirmAddNewNote -> {
                if (editTextTitle.isNotBlank() && editTextDescription.isNotBlank() && editTextDescription.isNotBlank() && editTextExpirationDate.isNotBlank()) {
                    bitmap = imageView_note_form_showNotePhoto.drawable.toBitmap()

                    val noteObject = Note(
                        editTextTitle,
                        editTextDescription,
                        editTextExpirationDate,
                        bitmap
                    )
                    val findNotesFragment = fragmentManager?.findFragmentByTag("NotesFragment") as NotesFragment

                    findNotesFragment.notesFragmentPresenter.initiateAddNote(noteObject)

                    fragmentManager?.popBackStack()
                }
                else {
                    textView_note_form_showErrorMessage.text = resources.getString(R.string.note_form_textView_showErrorMessage)
                    textView_note_form_showErrorMessage.setTextColor(ContextCompat.getColor(context?.applicationContext!!, R.color.colorRed))
                }
            }
            R.id.button_note_form_datePicker -> {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val datePickerDialog = DatePickerDialog(
                        context!!,
                        android.R.style.Theme_Dialog,
                        this,
                        LocalDate.now().year,
                        LocalDate.now().month.value - 1,
                        LocalDate.now().dayOfMonth
                    )
                    datePickerDialog.show()
                }
            }
            R.id.button_note_form_addNotePhoto -> {
                if (ActivityCompat.checkSelfPermission(context!!, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE), 456)
                } else {
                    val intentActionPick = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                    startActivityForResult(intentActionPick, 123)
                }
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 123) {
                imageURI = data?.data
                imageView_note_form_showNotePhoto?.setImageURI(imageURI)
            }
        }
    }

    override fun initializeListeners() {
        button_note_form_confirmAddNewNote.setOnClickListener(this)
        button_note_form_datePicker.setOnClickListener(this)
        button_note_form_addNotePhoto.setOnClickListener(this)
    }

    override fun onDateSet(view: DatePicker?, year: Int, monthOfYear: Int, dayOfMonth: Int) {
//        val rusLocale = Locale("ru", "RU")
//        ${String.format(rusLocale,"%tB",Calendar.getInstance())}
        val checkDayOfMonth = when {
            dayOfMonth < 10 -> "0${dayOfMonth}"
            dayOfMonth >= 10 -> "$dayOfMonth"
            else -> null
        }
        val checkMonthOfYear = when {
            monthOfYear.plus(1) < 10 -> "0${monthOfYear.plus(1)}"
            monthOfYear.plus(1) >= 10 -> "${monthOfYear.plus(1)}"
            else -> null
        }
        noteExpirationDate?.setText("$year-$checkMonthOfYear-$checkDayOfMonth")
    }
}