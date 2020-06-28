package com.example.myapplication12

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    var buttonGoToRecognizerIntent: Button? = null
    var textViewTranslateSpeech: TextView? = null
    var recognitionListener: Listener? = null
    var REQUEST_CODE = 123
    override fun onCreate(savedInstanceState: Bundle?) {
        //ВАЖНО! ПРОЧТИТЕ!
        //Суюн, на всякий случай, если вдруг вы не знаете:
        //чтобы приложение работало на эмуляторе - нужно перейти в More ("..." на боковой панели) -> Microphone -> Включить "Virtual microphone uses host audio input"
        //Сам долго с этим мучился, ни в какую не распознавалась речь, пока я не нашёл как это исправить

        //И ещё: на эмуляторе будет работать только на поздних версиях. У меня была Lollipop (5.0) - не работало даже с включенной опцией, скачал R (10.0) - всё работает
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        buttonGoToRecognizerIntent = findViewById(R.id.button_activity_main_voiceButton)
        textViewTranslateSpeech = findViewById(R.id.textView_activity_main_speech_text)
        recognitionListener = Listener()
    }
    fun initializeListeners() {
        buttonGoToRecognizerIntent?.setOnClickListener {
            val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(this)
            speechRecognizer.setRecognitionListener(recognitionListener)
            val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)

            speechRecognizer.startListening(intent)

            startActivityForResult(intent, REQUEST_CODE)

        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val getStringArrayList = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    textViewTranslateSpeech?.text = getStringArrayList?.get(0)
                }
            }
        }
    }
}