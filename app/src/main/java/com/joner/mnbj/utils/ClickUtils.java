package com.joner.mnbj.utils;

/**
 * Created by gpfei on 2018/6/2.
 * 点击事件
 */

public class ClickUtils {
    // 两次点击按钮之间的点击间隔不能少于3000毫秒
    private static final int MIN_CLICK_DELAY_TIME = 3000;
    // 登陆错误时间5分钟限制操作
    private static final int LOGIN_CLICK_DELAY_TIME = 300000;

    private static long lastClickTime;
    private static long lastLoginClickTime;

    public static boolean isFastClick() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastClickTime) >= MIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        Logger.e("ClickUtils", "isFastClick:" + (curClickTime - lastClickTime));
        lastClickTime = curClickTime;
        return flag;
    }

    public static boolean LoginErrorTime() {
        boolean flag = false;
        long curClickTime = System.currentTimeMillis();
        if ((curClickTime - lastLoginClickTime) >= LOGIN_CLICK_DELAY_TIME) {
            flag = true;
        }
        lastLoginClickTime = curClickTime;
        Logger.e("ClickUtils", "lastLoginClickTime:" + lastLoginClickTime);
        Logger.e("ClickUtils", "LoginErrorTime:" + (curClickTime - lastLoginClickTime));
        return flag;
    }
}
