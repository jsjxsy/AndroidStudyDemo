package com.example.test_webview_demo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.webkit.JavascriptInterface;

/**
 * @author xiaosy
 * @create 2/2/21
 * @Describe
 **/
public class AndroidCommonJS {
    private Activity activity;
    public AndroidCommonJS(Activity activity) {
        this.activity = activity;
    }

    @SuppressLint("JavascriptInterface")
    @JavascriptInterface
    public void closePage() {
        if(activity != null){
            activity.finish();
        }
    }

}
