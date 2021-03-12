package com.xsy.customview.workmanagerdemo

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {
    private lateinit var oneTimeWorkRequest: WorkRequest
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
                startWork()
            }
        }
        button2.setOnClickListener {
            stopWork()
        }
        button3.setOnClickListener {
            startPeriodicWork()
        }
        button4.setOnClickListener {
            startMultiWork();
        }
    }

    private fun startMultiWork() {
        val request1 = OneTimeWorkRequestBuilder<MyWork>().build()
        val request2 = OneTimeWorkRequestBuilder<MyWork>().build()
        val request3 = OneTimeWorkRequestBuilder<MyWork>().build()
        val request4 = OneTimeWorkRequestBuilder<MyWork>().build()


        WorkManager.getInstance(this)
                .beginWith(listOf(request1,request2,request3))
                .enqueue()
//
//        WorkManager.getInstance(this)
//                .beginWith(request1)
//                .then(request2)
//                .then(request3)
//                .enqueue()
//
//        val chuan1 = WorkManager.getInstance(this)
//                .beginWith(request1)
//                .then(request2)
//        val chuan2 = WorkManager.getInstance()
//                .beginWith(request3)
//                .then(request4)
//        WorkContinuation
//                .combine(listOf(chuan1, chuan2))
//                .enqueue()
    }

    /**
     * 默认间隔 15 分钟 弹性间隔 5 分钟
     * 2021-03-11 14:13:21.105 32558-32558/com.xsy.customview.workmanagerdemo W/WM-WorkSpec: Interval duration lesser than minimum allowed value; Changed to 900000
     * 2021-03-11 14:13:21.105 32558-32558/com.xsy.customview.workmanagerdemo W/WM-WorkSpec: Flex duration lesser than minimum allowed value; Changed to 300000
     */
    private fun startPeriodicWork() {
//        val request2 = PeriodicWorkRequest.Builder(MyWork::class.java, 10, TimeUnit.SECONDS).build()
        val data = Data.Builder()
                .putString("name", "li si")
                .putInt("age", 40)
                .build();
        val request = PeriodicWorkRequestBuilder<MyWork>(2, TimeUnit.SECONDS, 1, TimeUnit.SECONDS)
                .setInputData(data)
                .build()
        WorkManager.getInstance(this).enqueue(request)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(request.id).observe(this, {
            when (it.state) {
                WorkInfo.State.SUCCEEDED -> {
                    val workInfo = WorkManager.getInstance(this).getWorkInfoById(request.id).get()
                    val status = workInfo.outputData.getString("status")
                    val code = workInfo.outputData.getInt("code", 0)
                    Log.e("xsy", "result code: $code status: $status")
                }
            }
        })

    }

    private fun stopWork() {
        WorkManager.getInstance(this).cancelWorkById(oneTimeWorkRequest.id)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    private fun startWork() {
        val data = Data.Builder()
                .putString("name", "zhang san")
                .putInt("age", 12)
                .build()
        val constraints = Constraints.Builder()
                .setRequiresDeviceIdle(true) //触发时设备是否为空闲
                .setRequiresCharging(true) //触发时设备是否充电
                .setRequiredNetworkType(NetworkType.UNMETERED) //触发时网络状态
                .setRequiresBatteryNotLow(true) //指定设备电池是否不应低于临界阈值
                .setRequiresStorageNotLow(true) //指定设备可用存储是否不应低于临界阈值
                .build()

        oneTimeWorkRequest = OneTimeWorkRequestBuilder<MyWork>()
                .setInitialDelay(10, TimeUnit.SECONDS)
                .addTag("A")
                .setConstraints(constraints)
                .setInputData(data)
                .build()

        WorkManager.getInstance(this).enqueue(oneTimeWorkRequest)
        WorkManager.getInstance(this).getWorkInfoByIdLiveData(oneTimeWorkRequest.id).observe(this, {
            when (it.state) {
                WorkInfo.State.BLOCKED -> {
                    Log.e("xsy", "work state BLOCKED")
                }
                WorkInfo.State.RUNNING -> {
                    val progress = it.progress.getInt("process", 0)
                    Log.e("xsy", "work state RUNNING progress: $progress")
                }
                WorkInfo.State.ENQUEUED -> {
                    Log.e("xsy", "work state ENQUEUED")
                }
                WorkInfo.State.CANCELLED -> {
                    Log.e("xsy", "work state CANCELLED")
                    val status = it.outputData.getString("status")
                    val code = it.outputData.getInt("code", 0)
                    Log.e("xsy", "result code: $code status: $status")
                }
                WorkInfo.State.FAILED -> {
                    Log.e("xsy", "work state FAILED")
                }
                WorkInfo.State.SUCCEEDED -> {
                    Log.e("xsy", "work state SUCCEEDED")
                    val status = it.outputData.getString("status")
                    val code = it.outputData.getInt("code", 0)
                    Log.e("xsy", "result code: $code status: $status")

                }

            }
        })

        val workInfo = WorkManager.getInstance(this@MainActivity).getWorkInfoById(oneTimeWorkRequest.id).get()
        val status = workInfo.outputData.getString("status")
        val code = workInfo.outputData.getInt("code", 0)
        Log.e("xsy", "result code: $code status: $status")

    }
}