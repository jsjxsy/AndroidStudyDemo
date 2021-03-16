package com.xsy.module_2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.startup.Initializer;

import java.util.Collections;
import java.util.List;

/**
 * @author: xiaosy
 * 时间: 3/16/21
 * @Description: 初始化SDK2
 * @Version: 1.0
 **/
public class Sdk2Initializer implements Initializer<Sdk2> {
    @NonNull
    @Override
    public Sdk2 create(@NonNull Context context) {
        Sdk2.init(context);
        return Sdk2.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
