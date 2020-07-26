package com.example.myapplication21.leetcode

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication21.R
import kotlinx.android.synthetic.main.leetcode_file.*

class CheckPalindrome: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.leetcode_file)
        initializeListeners()
    }

    fun initializeListeners() {
        button_leetcode_file_checkPalindrome.setOnClickListener {

            if (editText_leetcode_file_setPalindrome.text.isNotBlank()) {
                if (!editText_leetcode_file_setPalindrome.text.startsWith("0")) {
                    textView_leetcode_file_showResult?.text = "Палиндром: ${isPalindrome(editText_leetcode_file_setPalindrome.text.toString().toInt())}"
                    when (isPalindrome(editText_leetcode_file_setPalindrome.text.toString().toInt())) {
                        true -> textView_leetcode_file_showResult?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorLightGreen))
                        false -> textView_leetcode_file_showResult?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                    }
                }
                else {
                    textView_leetcode_file_showResult?.text = "Число не может начинаться с нуля"
                    textView_leetcode_file_showResult?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
                }
            }
            else {
                textView_leetcode_file_showResult?.text = "Вы ничего не ввели!"
                textView_leetcode_file_showResult?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
            }
        }
    }

    fun isPalindrome(x: Int): Boolean {
        return x.toString() == x.toString().reversed()
    }
}

