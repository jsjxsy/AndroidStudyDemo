package com.xsy.customview.jobschdulerdemo

import android.app.job.JobParameters
import android.app.job.JobService
import android.content.Intent
import android.os.SystemClock
import android.util.Log
import android.widget.Toast




/**
 *@author xiaosy
 *@create 3/11/21
 *@Describe
 **/
class MyJobService: JobService() {
    override fun onStartJob(params: JobParameters?): Boolean {
        // 返回true，表示该工作耗时，同时工作处理完成后需要调用onStopJob销毁（jobFinished）
        // 返回false，任务运行不需要很长时间，到return时已完成任务处理
        Log.e("xsy", "start job id: ${params?.jobId}")
        Log.e("xsy", "params name: ${params?.extras?.getString("name")} " +
                "age: ${params?.extras?.getInt("age")}")

        doMyJob(params)
        return true
    }

    override fun onStopJob(params: JobParameters?): Boolean {
        // 有且仅有onStartJob返回值为true时，才会调用onStopJob来销毁job
        // 返回false来销毁这个工作
        Log.e("xsy", "stop job id: ${params?.jobId}")
        return true
    }

    private fun doMyJob(params: JobParameters?) {
        Toast.makeText(applicationContext, "Job Service执行", Toast.LENGTH_SHORT).show()
        Log.e("xsy", "do My Job id: ${params?.jobId}")
        jobFinished(params, false)
    }

    override fun onCreate() {
        super.onCreate()
        Log.e("xsh","onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
        Log.e("xsh","onStartCommand")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("xsh","onDestroy")
    }
}