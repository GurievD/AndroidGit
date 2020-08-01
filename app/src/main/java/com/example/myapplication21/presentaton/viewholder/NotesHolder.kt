package com.example.myapplication21.presentaton.viewholder

import android.content.Context
import android.os.Build
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.data.Note
import com.example.myapplication21.presentaton.recycler.OnNoteItemClickListener
import kotlinx.android.synthetic.main.note_list_item.view.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class NotesHolder (itemView: View): RecyclerView.ViewHolder(itemView) {
    var noteTitle: TextView = itemView.textView_note_list_item_noteTitle
    var noteDescription: TextView = itemView.textView_note_list_item_noteDescription
    var noteExpirationDate: TextView = itemView.textView_note_list_item_noteExpirationDate
    var context: Context? = null
    var myNote: Note? = null
    fun initiateBind(note: Note, action: OnNoteItemClickListener) {
        noteTitle.text = "Тема: ${note.noteTitle}"
        noteDescription.text = "Описание: ${note.noteDescription}"
        noteExpirationDate.text = "Дата выполнения: ${note.noteExpirationDate}"

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val localDateNow = LocalDate.now()
            val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern(note.noteExpirationDate)
            val localDateParse = LocalDate.parse(dateTimeFormatter.format(localDateNow), DateTimeFormatter.ISO_LOCAL_DATE)

            if (localDateNow == localDateParse || localDateNow >= localDateParse) {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorLightRed))
            }
            else {
                itemView.setBackgroundColor(ContextCompat.getColor(itemView.context, R.color.colorLightGreen))
            }
        }
    }
}