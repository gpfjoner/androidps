package com.joner.mnbj.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

import com.joner.mnbj.utils.AppSHAUtils;
import com.joner.mnbj.utils.Logger;


/**
 * Created by gpfei on 2018/6/7.
 * 全局控件初始化区域
 */

public class BaseApplication extends Application {
    public static SQLiteDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        //***********初始化全局异常处理类 用Bugly捕获应用程序异常***********
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        String sHA1 = AppSHAUtils.sHA1(getApplicationContext());
        Logger.e("tag:", "HA1:" + sHA1);
        //MobSDK.init(this);
        //android 7.0 手机系统调用摄像图操作。
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

}
