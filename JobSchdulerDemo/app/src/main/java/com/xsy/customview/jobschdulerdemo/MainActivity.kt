package com.xsy.customview.jobschdulerdemo

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        private var JOB_SCHEDULER_ID = 11
    }

    private lateinit var jobScheduler: JobScheduler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                startJobScheduler()
            }
        }
        button2.setOnClickListener {
            cancelJobScheduler()
        }
    }

    private fun cancelJobScheduler() {
        jobScheduler.cancelAll()
    }

    override fun onStart() {
        super.onStart()
//        val intent = Intent(this, MyJobService::class.java)
//        startService(intent)

    }

    override fun onStop() {
        super.onStop()
//        val flag = stopService(Intent(this, MyJobService::class.java))
//        if(!flag){
//            Toast.makeText(this, "service stop fail", Toast.LENGTH_SHORT).show()
//        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun startJobScheduler() {
        jobScheduler = getSystemService(JOB_SCHEDULER_SERVICE) as JobScheduler
        val jobComponent = ComponentName(this, MyJobService::class.java)
        val extras = PersistableBundle()
        extras.putString("name", "zhang san")
        extras.putInt("age", 14)
        val jobInfo = JobInfo.Builder(JOB_SCHEDULER_ID++, jobComponent)
//                .setPeriodic(1000 * 1) //系统约束，小于15分钟不会生效，必须大于15分钟。
//                .setRequiresDeviceIdle(true)
//                .setRequiresCharging(false)
//                .setRequiresBatteryNotLow(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                .setExtras(extras)
                .build()
        val jobId = jobScheduler.schedule(jobInfo)
        if (jobId < 0) {
            Toast.makeText(this, "job scheduler is fail", Toast.LENGTH_SHORT).show()
        } else {

        }
    }
}