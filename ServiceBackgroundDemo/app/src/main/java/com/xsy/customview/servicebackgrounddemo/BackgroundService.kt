package com.xsy.customview.servicebackgrounddemo

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.util.Log

class BackgroundService : Service() {

    override fun onBind(intent: Intent): IBinder? {
       return null
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("xsy", "BackgroundService onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        createNotificationChannel();
        return super.onStartCommand(intent, flags, startId)
    }
    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notification_id = (System.currentTimeMillis() % 10000).toInt()
            val channel = NotificationChannel("40", "app", NotificationManager.IMPORTANCE_DEFAULT)
            val manager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
            val notification = Notification.Builder(applicationContext, "40").build()
            startForeground(notification_id, notification)
        }
    }
}