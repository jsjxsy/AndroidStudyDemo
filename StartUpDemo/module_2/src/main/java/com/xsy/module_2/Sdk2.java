package com.xsy.module_2;

import android.content.Context;
import android.util.Log;

/**
 * @author: xiaosy
 * 时间: 3/16/21
 * @Description: java类作用描述
 * @Version: 1.0
 **/
public class Sdk2 {
    private static final String TAG = "Sdk2";

    private static Context sApplicationContext;

    private static volatile Sdk2 sInstance;

    public static void init(Context applicationContext){
        sApplicationContext = applicationContext;
        Log.e(TAG, "Sdk2 is initialized");
    }

    public static Sdk2 getInstance(){
        if (sInstance == null) {
            synchronized (Sdk2.class){
                if (sInstance == null) {
                    sInstance = new Sdk2();
                }
            }
        }
        return sInstance;
    }

    private Sdk2(){
    }

    public void printApplicationName(){
        Log.e(TAG, sApplicationContext.getPackageName());
    }
}
