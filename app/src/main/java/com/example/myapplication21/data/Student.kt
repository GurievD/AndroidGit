package com.example.myapplication21.data

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

class Student(var studentName: String?, var studentLastName: String?, var studentDescription: String?, var avatar: Bitmap?, var studentGroup: Int, var studentMark: Float, var flag: Boolean) : Parcelable,
    Serializable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readParcelable(Bitmap::class.java.classLoader),
        parcel.readInt(),
        parcel.readFloat(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(studentName)
        parcel.writeString(studentLastName)
        parcel.writeString(studentDescription)
        parcel.writeParcelable(avatar, flags)
        parcel.writeInt(studentGroup)
        parcel.writeFloat(studentMark)
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