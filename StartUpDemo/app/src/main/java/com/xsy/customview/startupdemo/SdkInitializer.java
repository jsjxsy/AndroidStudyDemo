package com.xsy.customview.startupdemo;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.Collections;
import java.util.List;

/**
 * @author: xiaosy
 * 时间: 3/16/21
 * @Description: 初始化SDK
 * @Version: 1.0
 **/
public class SdkInitializer implements Initializer<Sdk> {
    @NonNull
    @Override
    public Sdk create(@NonNull Context context) {
        Sdk.init(context);
        return Sdk.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
