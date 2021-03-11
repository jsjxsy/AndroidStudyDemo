package com.xsy.customview.servicebackgrounddemo

import android.app.Application
import com.xsy.customview.servicebackgrounddemo.MyService

/**
 * @author xiaosy
 * @create 3/10/21
 * @Describe
 */
class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val intent: `val` = Intent(applicationContext, MyService::MyService::)
        java
        startService(intent)
    }
}