package com.joner.mnbj.application;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.StrictMode;

import com.joner.mnbj.greendao.gen.DaoMaster;
import com.joner.mnbj.greendao.gen.DaoSession;
import com.joner.mnbj.utils.AppSHAUtils;
import com.joner.mnbj.utils.Consts;
import com.joner.mnbj.utils.Logger;
import com.pgyersdk.crash.PgyCrashManager;

import org.greenrobot.greendao.database.Database;


/**
 * Created by gpfei on 2018/6/7.
 * 全局控件初始化区域
 */

public class BaseApplication extends Application {
    public static DaoSession daoSession;
    public static SQLiteDatabase db;
    public DaoMaster.DevOpenHelper helper;
    public DaoMaster daoMaster;

    @Override
    public void onCreate() {
        super.onCreate();
        //***********初始化全局异常处理类 用Bugly捕获应用程序异常***********
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);
        String sHA1 = AppSHAUtils.sHA1(getApplicationContext());
        Logger.e("tag:", "HA1:" + sHA1);
        //MobSDK.init(this);
        setupDatabase(true);
        setupDatabase(false);
        PgyCrashManager.register(this);// 注册Crash接口（必选）
        //android 7.0 手机系统调用摄像图操作。
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        builder.detectFileUriExposure();

    }


    private void setupDatabase(boolean style) {
        // 通过 DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的 SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为 greenDAO 已经帮你做了。
        // 注意：默认的 DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        String dbstyle = null;
        if (style) {
            dbstyle = Consts.USER_INFOR_DB_NAME;//用户数据库
        } else {
            dbstyle = Consts.USER_STORE_INFOR_DB;//账务存储数据库
        }
        helper = new DaoMaster.DevOpenHelper(this, dbstyle, null);
        db = helper.getWritableDatabase();
        // 注意：该数据库连接属于 DaoMaster，所以多个 Session 指的是相同的数据库连接。
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }

    /*public DaoSession getDaoSession() {
        return daoSession;
    }*/
    public static DaoSession getDaoSession() {
        return daoSession;
    }

    public static SQLiteDatabase getDb() {
        return db;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

}
