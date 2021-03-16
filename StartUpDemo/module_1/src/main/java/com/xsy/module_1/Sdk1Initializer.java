package com.xsy.module_1;

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
public class Sdk1Initializer implements Initializer<Sdk1> {
    @NonNull
    @Override
    public Sdk1 create(@NonNull Context context) {
        Sdk1.init(context);
        return Sdk1.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
