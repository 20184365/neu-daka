package com.example.daka
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {
    val MYTAG = "Ray"
    override fun onReceive(context: Context, intent: Intent) {
        // TODO Auto-generated method stub
        Log.v(MYTAG, "I am AlarmReceiver,I receive the message")
        val `in` = Intent()
        `in`.setClass(context, MainActivity::class.java)
        `in`.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(`in`)
    }
}