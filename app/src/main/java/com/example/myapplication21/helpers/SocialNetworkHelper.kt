package com.example.myapplication21.helpers

import android.content.Context
import android.content.Intent
import android.net.Uri
import com.example.myapplication21.presentaton.contract.SocialNetworkHelperContract

class SocialNetworkHelper(var context: Context): SocialNetworkHelperContract {
    override fun initiateSMS(text: String) {
        val phoneNumber = "+77711949025"
        val intentSendsToSecondPage = Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", phoneNumber, null))
        intentSendsToSecondPage.putExtra("sms_body", text)
        context.startActivity(intentSendsToSecondPage)
    }
}