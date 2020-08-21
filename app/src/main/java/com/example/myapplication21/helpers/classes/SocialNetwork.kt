package com.example.myapplication21.helpers.classes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication21.R
import com.example.myapplication21.helpers.SocialNetworkHelper
import kotlinx.android.synthetic.main.social_network.*

class SocialNetwork: AppCompatActivity() {
    var socialNetworkHelper: SocialNetworkHelper = SocialNetworkHelper(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.social_network)

        initializeListeners()
    }

    fun initializeListeners() {

        button_social_network_sendToWhatsapp.setOnClickListener {
            socialNetworkHelper.initiateSMS(editText_social_network_setMessage.text.toString())
        }
    }
}