package com.example.myapplication21.data

import android.os.Parcel
import android.os.Parcelable

class Subject(var subjectTitle: String, var arrayListOfStudents: ArrayList<Student>) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt().toString(),
        parcel.readArrayList(Student::class.java.classLoader) as ArrayList<Student>
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(this.subjectTitle)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Subject> {
        override fun createFromParcel(parcel: Parcel): Subject {
            return Subject(parcel)
        }

        override fun newArray(size: Int): Array<Subject?> {
            return arrayOfNulls(size)
        }
    }
}