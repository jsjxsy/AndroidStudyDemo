package com.xsy.module_3;

import android.content.Context;
import android.util.Log;

/**
 * @author: xiaosy
 * 时间: 3/16/21
 * @Description: java类作用描述
 * @Version: 1.0
 **/
public class Sdk3 {
    private static final String TAG = "Sdk3";

    private static Context sApplicationContext;

    private static volatile Sdk3 sInstance;

    public static void init(Context applicationContext){
        sApplicationContext = applicationContext;
        Log.e(TAG, "Sdk3 is initialized");
    }

    public static Sdk3 getInstance(){
        if (sInstance == null) {
            synchronized (Sdk3.class){
                if (sInstance == null) {
                    sInstance = new Sdk3();
                }
            }
        }
        return sInstance;
    }

    private Sdk3(){
    }

    public void printApplicationName(){
        Log.e(TAG, sApplicationContext.getPackageName());
    }
}
