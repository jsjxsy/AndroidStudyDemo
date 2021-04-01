package com.xsy.customview.servicebackgrounddemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

/**
 * 模拟启动后台进程
 *  Not allowed to start service Intent { cmp=com.xsy.customview.servicebackgrounddemo/.MyService }: app is in background u
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.startService).setOnClickListener(View.OnClickListener {
//            val intent = Intent(MainActivity::this, MyService::class.java)
            it.postDelayed(Runnable {
                val intent = Intent(this, MyService::class.java)
                startService(intent)
            }, 1000*65)
        })

        findViewById<Button>(R.id.startSecond).setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }

        findViewById<Button>(R.id.startBackgroundService).setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                it.postDelayed({
                    startForegroundService(Intent(this, BackgroundService::class.java))
                }, 1000*65)
            }
        }
    }
}


