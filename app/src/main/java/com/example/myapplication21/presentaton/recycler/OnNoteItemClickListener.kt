package com.example.myapplication21.presentaton.recycler

import com.example.myapplication21.domain.Note

interface OnNoteItemClickListener {
    fun onNoteItemClick(item: Note, adapterPosition: Int)
}