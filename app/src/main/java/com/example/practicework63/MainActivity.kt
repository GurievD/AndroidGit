package com.example.practicework63

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import java.util.*
import kotlin.concurrent.schedule


class MainActivity : AppCompatActivity(), View.OnClickListener {

    var buttonFirstOption: Button? = null
    var buttonSecondOption: Button? = null
    var buttonThirdOption: Button? = null
    var buttonFourthOption: Button? = null
    var answerIndex = 1
    var scoreForRightAnswers = 0
    var scoreForWrongAnswers = 0
    var textViewToShowQuestions: TextView? = null
    var textViewToCheckAnswers: TextView? = null

    val arrayOfQuestions = arrayOf(
        "День спит, ночь глядит, утром умирает, другой сменяет.",
        "Хоть без глаз, могу бегущих догонять, но только никому меня нельзя обнять.",
        "С одного дерева да четыре угодья: первое от тёмной ночи свет, второе – некопаный колодец, третье – старому здоровье, четвёртое – разбитому связь.",
        "Без языка, а сказывается.",
        "Не море, не земля, корабли не плавают, а ходить нельзя."

    )

    val arrayOfAnswers = arrayOf(
        "Свеча",
        "Тень",
        "Берёза",
        "Боль",
        "Болото"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeView()
        textViewToShowQuestions?.text = arrayOfQuestions[0]
    }

    fun initializeView() {
        //Написал на паре за короткое время, сильно не ругайте :)
        //Возможно, можно было реализовать лучше, но времени было мало на практическую чтобы всё до ума довести,
        // и сделать работу ещё лучше

        //^
        //|
        //|

        //Выше - старый комментарий, который был написан ещё на паре
        //Извините, забыл запушить в гитхаб и залить в MyStat эту практическую,
        // которую делал на паре ещё около недели назад

        //Обидно, но надеюсь вы посмотрите работу
        textViewToShowQuestions = findViewById(R.id.textView_activity_main_showQuestions)
        textViewToCheckAnswers = findViewById(R.id.textView_activity_main_checkAnswer)
        buttonFirstOption = findViewById(R.id.button_activity_main_firstOption)
        buttonSecondOption = findViewById(R.id.button_activity_main_secondOption)
        buttonThirdOption = findViewById(R.id.button_activity_main_thirdOption)
        buttonFourthOption = findViewById(R.id.button_activity_main_fourthOption)

        buttonFirstOption?.setOnClickListener(this)
        buttonSecondOption?.setOnClickListener(this)
        buttonThirdOption?.setOnClickListener(this)
        buttonFourthOption?.setOnClickListener(this)

    }

    fun postDelayed() {
        textViewToCheckAnswers?.postDelayed({
            textViewToCheckAnswers?.visibility = View.INVISIBLE
        }, 500)

        textViewToCheckAnswers?.visibility = View.VISIBLE
    }

    fun rightAnswer() {
        scoreForRightAnswers++
        textViewToCheckAnswers?.text = "ПРАВИЛЬНО!"
        textViewToCheckAnswers?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorGreen))
    }
    fun wrongAnswer() {
        scoreForWrongAnswers++
        textViewToCheckAnswers?.text = "НЕПРАВИЛЬНО!"
        textViewToCheckAnswers?.setTextColor(ContextCompat.getColor(baseContext, R.color.colorRed))
    }

    override fun onClick(v: View?) {
        if (answerIndex < arrayOfQuestions.size) {

            when (v?.id) {
                R.id.button_activity_main_firstOption -> {
                    textViewToShowQuestions?.text = arrayOfQuestions[answerIndex++]
                    wrongAnswer()
                    postDelayed()
                }
                R.id.button_activity_main_secondOption -> {
                    textViewToShowQuestions?.text = arrayOfQuestions[answerIndex++]
                    when (buttonSecondOption?.text) {
                        arrayOfAnswers[3] -> {
                            rightAnswer()
                            postDelayed()
                        }
                        else -> {
                            wrongAnswer()
                            postDelayed()
                        }
                    }
                }
                R.id.button_activity_main_thirdOption -> {
                    textViewToShowQuestions?.text = arrayOfQuestions[answerIndex++]
                    when (buttonThirdOption?.text) {
                        arrayOfAnswers[2] -> {
                            rightAnswer()
                            postDelayed()
                        }
                        else -> {
                            wrongAnswer()
                            postDelayed()
                        }
                    }
                }
                R.id.button_activity_main_fourthOption -> {
                    textViewToShowQuestions?.text = arrayOfQuestions[answerIndex++]

                    when (buttonFourthOption?.text) {
                        arrayOfAnswers[0] -> {
                            rightAnswer()
                            postDelayed()
                        }
                        arrayOfAnswers[1] -> {
                            rightAnswer()
                            postDelayed()
                        }
                        else -> {
                            wrongAnswer()
                            postDelayed()
                        }
                    }
                }
            }
            when (answerIndex) {
                2 -> {
                    buttonFirstOption?.text = "Деньги"
                    buttonSecondOption?.text = "Туча"
                    buttonThirdOption?.text = "Звезда"
                    buttonFourthOption?.text = "Тень"
                }
                3 -> {

                    buttonFirstOption?.text = "Любовь"
                    buttonSecondOption?.text = "Огонь"
                    buttonThirdOption?.text = "Берёза"
                    buttonFourthOption?.text = "Счастье"
                }
                4 -> {

                    buttonFirstOption?.text = "Жест"
                    buttonSecondOption?.text = "Боль"
                    buttonThirdOption?.text = "Лай"
                    buttonFourthOption?.text = "Старость"
                }
                5 -> {
                    buttonFirstOption?.text = "Болото"
                    buttonSecondOption?.text = "Лава"
                    buttonThirdOption?.text = "Угли"
                    buttonFourthOption?.text = "Небеса"
                }
            }
        }
        else {
            when (v?.id) {
                R.id.button_activity_main_firstOption -> {
                    when (buttonFirstOption?.text) {
                        arrayOfAnswers[4] -> {
                            rightAnswer()
                            postDelayed()
                        }
                    }
                }
                else -> {
                    wrongAnswer()
                    postDelayed()
                }
            }
            val intentGoToScoreActivity = Intent(this, ScoreActivity::class.java)
            Timer().schedule(500) {
                intentGoToScoreActivity.putExtra("scoreRight", scoreForRightAnswers)
                intentGoToScoreActivity.putExtra("scoreWrong", scoreForWrongAnswers)
                startActivity(intentGoToScoreActivity)
                finish()
            }

        }
    }
}