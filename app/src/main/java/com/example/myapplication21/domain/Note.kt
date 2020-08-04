package com.example.myapplication21.domain

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Note(var noteTitle: String, var noteDescription: String, var noteExpirationDate: String, var notePhoto: Bitmap?) :
    Serializable, Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readParcelable(Bitmap::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(noteTitle)
        parcel.writeString(noteDescription)
        parcel.writeString(noteExpirationDate)
        parcel.writeParcelable(notePhoto, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Note> {
        override fun createFromParcel(parcel: Parcel): Note {
            return Note(parcel)
        }

        override fun newArray(size: Int): Array<Note?> {
            return arrayOfNulls(size)
        }
    }

}