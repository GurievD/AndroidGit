package com.example.myapplication21.presentaton.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication21.R
import com.example.myapplication21.data.Note
import com.example.myapplication21.presentaton.recycler.OnNoteItemClickListener
import com.example.myapplication21.presentaton.viewholder.NotesHolder
import kotlinx.android.synthetic.main.note_list_item.view.*
import java.io.InputStream

class NotesAdapter(var context: Context?, var arrayListOfNotes: ArrayList<Note>, var onNoteItemClickListener: OnNoteItemClickListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var inputStream: InputStream? =  null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflateView = LayoutInflater.from(context).inflate(R.layout.note_list_item, parent, false)
        return NotesHolder(inflateView)
    }

    override fun getItemCount(): Int {
        return arrayListOfNotes.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NotesHolder).initiateBind(arrayListOfNotes[position], onNoteItemClickListener)
        val noteShowImage: ImageView = holder.itemView.imageView_note_list_item_showImage

        openAssets()
        val drawableCreateFromStream = Drawable.createFromStream(inputStream, null)

        if (holder.myNote?.notePhoto != null) {
            noteShowImage.setImageBitmap(holder.myNote?.notePhoto)
        }
        else {
            noteShowImage.setImageDrawable(drawableCreateFromStream)
        }
    }
    fun openAssets(): InputStream? {
        inputStream = context?.assets?.open("magnifier.png")
        return inputStream
    }

}