package com.xsy.module_1;

import android.content.Context;
import android.util.Log;

/**
 * @author: xiaosy
 * 时间: 3/16/21
 * @Description: java类作用描述
 * @Version: 1.0
 **/
public class Sdk1 {
    private static final String TAG = "Sdk1";

    private static Context sApplicationContext;

    private static volatile Sdk1 sInstance;

    public static void init(Context applicationContext){
        sApplicationContext = applicationContext;
        Log.e(TAG, "Sdk1 is initialized");
    }

    public static Sdk1 getInstance(){
        if (sInstance == null) {
            synchronized (Sdk1.class){
                if (sInstance == null) {
                    sInstance = new Sdk1();
                }
            }
        }
        return sInstance;
    }

    private Sdk1(){
    }

    public void printApplicationName(){
        Log.e(TAG, sApplicationContext.getPackageName());
    }
}
