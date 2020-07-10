package com.example.myapplication19

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class StudentsActivity: AppCompatActivity() {
    var currentFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_students)

        initializeDefaultFragment()
        displayFragment(StudentsInformationFragment())

    }

    //Не совсем понял

    //В задании сказано:
    //"Создайте StudentsFragment чтобы отображать список студентов"

    //но при этом говорится

    //"StudentsFragment можете оставить пустым без каких либо View"

    //Пока оставлю пустым, потом туда выведу список RecyclerView
    fun initializeDefaultFragment(){
        if(currentFragment == null){
            currentFragment = StudentsFragment()
            displayFragment(currentFragment!!)
        }
    }

    fun displayFragment(fragment: Fragment){

        this.currentFragment = fragment
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        supportFragmentManager.executePendingTransactions()
        fragmentTransaction.add(
            R.id.relativeLayout_activity_students_fragment_container,
            fragment,
            fragment.javaClass.name ?: "")

        fragmentTransaction.addToBackStack("Name")
        fragmentTransaction.commit()

    }

}