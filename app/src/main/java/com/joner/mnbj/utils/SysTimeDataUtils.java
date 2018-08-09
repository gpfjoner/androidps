package com.joner.mnbj.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by gpfei on 2018/7/18.
 * 时间获取类
 */

public class SysTimeDataUtils {
    /* XXXX-XX-XX*/
    public static String getSysTimeTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());
        //获取当前时间
        String str = formatter.format(curDate);
        return str;
    }
}
