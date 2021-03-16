package com.xsy.module_3;

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
public class Sdk3Initializer implements Initializer<Sdk3> {
    @NonNull
    @Override
    public Sdk3 create(@NonNull Context context) {
        Sdk3.init(context);
        return Sdk3.getInstance();
    }

    @NonNull
    @Override
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }
}
