package com.example.practicework63

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    var textViewToShowScoreResult: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.get_score)
        initializeView()
        initializeListeners()
    }
    fun initializeView() {
        textViewToShowScoreResult = findViewById(R.id.textView_get_score_showScoreResult)
    }
    fun initializeListeners() {
        val getScoreRightAnswers = intent.getIntExtra("scoreRight", 0)
        val getScoreWrongAnswers = intent.getIntExtra("scoreWrong", 0)

        textViewToShowScoreResult?.text = "Правильных ответов: $getScoreRightAnswers\nНеправильных ответов: $getScoreWrongAnswers"
    }
}