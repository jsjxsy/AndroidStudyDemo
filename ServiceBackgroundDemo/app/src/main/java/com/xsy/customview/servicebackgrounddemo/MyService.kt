package com.xsy.customview.servicebackgrounddemo

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder? {
       return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("xsy","MyService onCreate")
    }

    override fun onStart(intent: Intent?, startId: Int) {
        super.onStart(intent, startId)
        Log.e("xsy","MyService onStart")
    }
}