package com.example.myapplication21.data

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Student(var studentName: String, var studentLastName: String, var studentDescription: String, var studentAvatar : Bitmap?, var studentMark: Float, var flag: Boolean) : Serializable, Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readParcelable(Bitmap::class.java.classLoader),
        parcel.readFloat(),
        parcel.readByte() != 0.toByte()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(studentName)
        parcel.writeString(studentLastName)
        parcel.writeString(studentDescription)
        parcel.writeFloat(studentMark)
        parcel.writeParcelable(studentAvatar, flags)
        parcel.writeByte(if (flag) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        override fun createFromParcel(parcel: Parcel): Student {
            return Student(parcel)
        }

        override fun newArray(size: Int): Array<Student?> {
            return arrayOfNulls(size)
        }
    }
}