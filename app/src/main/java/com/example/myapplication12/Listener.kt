package com.example.myapplication12

import android.os.Bundle
import android.speech.RecognitionListener
import android.util.Log


class Listener : RecognitionListener {
    //В этом классе я только создаю логи в переопределённых методах, и вывожу их в Logcat на какое-то событие
    //Только для теста работы методов, и ничего более
    override fun onReadyForSpeech(p0: Bundle?) {
        Log.d("TAG", "onReadyForSpeech");
    }

    override fun onRmsChanged(p0: Float) {
        Log.d("TAG", "onRmsChanged");
    }

    override fun onBufferReceived(p0: ByteArray?) {
        Log.d("TAG", "onBufferReceived");
    }

    override fun onPartialResults(p0: Bundle?) {
        Log.d("TAG", "onPartialResults");
    }

    override fun onEvent(p0: Int, p1: Bundle?) {
        Log.d("TAG", "onEvent");
    }

    override fun onBeginningOfSpeech() {
        Log.d("TAG", "onBeginningOfSpeech");
    }

    override fun onEndOfSpeech() {
        Log.d("TAG", "onEndOfSpeech");
    }

    override fun onError(p0: Int) {
        Log.d("TAG", "onError");
    }

    override fun onResults(p0: Bundle?) {
        Log.d("TAG", "onResults");
    }

}