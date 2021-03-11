package com.xsy.customview.servicebackgrounddemo

import android.app.Application
import android.content.Intent
import android.util.Log
import com.xsy.customview.servicebackgrounddemo.MyService

/**
 * @author xiaosy
 * @create 3/10/21
 * @Describe
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.e("xsy","MainApplication MyService")
        val intent = Intent(this, MyService::class.java)
        startService(intent)
        Log.e("xsy", "MainApplication MyService startService");
    }
}