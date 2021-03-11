package com.xsy.customview.servicebackgrounddemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Button

/**
 * application 启动后台应用
 */
class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        findViewById<Button>(R.id.kill).setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed(Runnable {
                Log.e("xsy","kill process")
                /**
                 * 后台执行无效
                 */
                android.os.Process.killProcess(android.os.Process.myPid())
            }, 1000 * 5)

        }
    }
}