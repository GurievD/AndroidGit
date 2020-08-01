package com.example.myapplication21.presentaton.recycler

import com.example.myapplication21.data.Note

interface OnNoteItemClickListener {
    fun onNoteItemClick(item: Note, adapterPosition: Int)
}