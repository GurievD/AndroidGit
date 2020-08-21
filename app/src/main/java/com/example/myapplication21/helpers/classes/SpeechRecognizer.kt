package com.example.myapplication21.helpers.classes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R
import com.example.myapplication21.helpers.SpeechRecognizerHelper
import kotlinx.android.synthetic.main.speech_recognizer.*

class SpeechRecognizer: AppCompatActivity() {
    var speechRecognizerHelper: SpeechRecognizerHelper = SpeechRecognizerHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.speech_recognizer)

        initializeView()
        initializeListeners()
    }

    fun initializeView() {
        speechRecognizerHelper.recognitionListener = Listener()
    }
    fun initializeListeners() {
        button_speech_recognizer_voiceButton.setOnClickListener {
            speechRecognizerHelper.initiateSpeechRecognition()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            speechRecognizerHelper.REQUEST_CODE -> {
                if (resultCode == Activity.RESULT_OK) {
                    val getStringArrayList = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
                    textView_speech_recognizer_speech_text?.text = getStringArrayList?.get(0)
                }
            }
        }
    }
}