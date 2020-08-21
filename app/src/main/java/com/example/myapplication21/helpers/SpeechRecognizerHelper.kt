package com.example.myapplication21.helpers

import android.app.Activity
import android.content.Intent
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import com.example.myapplication21.helpers.classes.Listener
import com.example.myapplication21.presentaton.contract.SpeechRecognizerHelperContract
import java.util.*

class SpeechRecognizerHelper(var activityContext: Activity): SpeechRecognizerHelperContract {
    var recognitionListener: Listener? = null
    var REQUEST_CODE = 123

    override fun initiateSpeechRecognition() {
        val speechRecognizer = SpeechRecognizer.createSpeechRecognizer(activityContext)
        speechRecognizer.setRecognitionListener(recognitionListener)
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)

        speechRecognizer.startListening(intent)

        activityContext.startActivityForResult(intent, REQUEST_CODE)
    }
}