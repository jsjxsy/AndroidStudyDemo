package com.xsy.customview.startupdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.startup.AppInitializer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //懒加载
        AppInitializer.getInstance(applicationContext)
                .initializeComponent(SdkInitializer::class.java)
        Sdk.getInstance().printApplicationName()
    }
}