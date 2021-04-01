package com.example.test_webview_demo;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.webkit.WebView;

import com.tencent.smtt.sdk.QbSdk;

import java.util.List;

public class APPAplication extends Application {

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		//搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
		
		QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {
			
			@Override
			public void onViewInitFinished(boolean arg0) {
				// TODO Auto-generated method stub
				//x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
				Log.d("app", " onViewInitFinished is " + arg0);
			}
			
			@Override
			public void onCoreInitFinished() {
				// TODO Auto-generated method stub
			}
		};
		//x5内核初始化接口
		QbSdk.initX5Environment(getApplicationContext(),  cb);

		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
			String processNameByAms = getCurrentProcessNameByAms();
			String suffix = processNameByAms + "-webkit";
			WebView.setDataDirectorySuffix(suffix);
		}
	}


	private String getCurrentProcessNameByAms() {
		try {
			ActivityManager am = (ActivityManager) this.getApplicationContext().getSystemService(Context.ACTIVITY_SERVICE);
			if (am == null) return "";
			List<ActivityManager.RunningAppProcessInfo> info = am.getRunningAppProcesses();
			if (info == null || info.size() == 0) return "";
			int pid = android.os.Process.myPid();
			for (ActivityManager.RunningAppProcessInfo aInfo : info) {
				if (aInfo.pid == pid) {
					if (aInfo.processName != null) {
						return aInfo.processName;
					}
				}
			}
		} catch (Exception e) {
			return "";
		}
		return "";
	}



}
