package com.xsy.customview.workmanagerdemo

import android.content.Context
import android.os.SystemClock
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

/**
 *@author xiaosy
 *@create 3/11/21
 *@Describe 要执行的任务
 **/
class MyWork(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {


    override fun onStopped() {
        Log.e("xsy", "on stopped")
        super.onStopped()
    }

    override fun doWork(): Result {
        Log.e("xsy", "do work")
//        for (i in 1..10){
//            val process = Data.Builder()
//                .putInt("process", i)
//                .build()
//            setProgressAsync(process)
//            SystemClock.sleep(1000 * 1)
//        }

        val name = inputData.getString("name")
        val age = inputData.getInt("age", 0)
        Log.e("xsy", "name: $name age: $age")
        val data = Data.Builder()
            .putString("status", "success")
            .putInt("code", 100)
            .build()
        return Result.success(data)
    }
}