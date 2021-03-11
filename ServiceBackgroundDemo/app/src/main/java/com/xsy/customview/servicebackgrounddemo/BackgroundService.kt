package com.xsy.customview.servicebackgrounddemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class BackgroundService : Service() {

    override fun onBind(intent: Intent): IBinder? {
       return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("xsy","BackgroundService onCreate")
        val intent = Intent(this, MyService::class.java)
        startService(intent)
        Log.e("xsy","startService MyService")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }
}