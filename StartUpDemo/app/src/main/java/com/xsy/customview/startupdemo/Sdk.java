package com.xsy.customview.startupdemo;

import android.content.Context;
import android.util.Log;

/**
 * @author: xiaosy
 * 时间: 3/16/21
 * @Description: java类作用描述
 * @Version: 1.0
 **/
public class Sdk {
    private static final String TAG = "Sdk";

    private static Context sApplicationContext;

    private static volatile Sdk sInstance;

    public static void init(Context applicationContext){
        sApplicationContext = applicationContext;
        Log.e(TAG, "Sdk is initialized");
    }

    public static Sdk getInstance(){
        if (sInstance == null) {
            synchronized (Sdk.class){
                if (sInstance == null) {
                    sInstance = new Sdk();
                }
            }
        }
        return sInstance;
    }

    private Sdk(){
    }

    public void printApplicationName(){
        Log.e(TAG, sApplicationContext.getPackageName());
    }
}
