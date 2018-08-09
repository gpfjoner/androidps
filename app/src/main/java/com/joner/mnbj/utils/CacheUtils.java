package com.joner.mnbj.utils;

import android.content.Context;

/**
 * Created by gpfei on 2018/4/11.
 *   
 */

public class CacheUtils {
    //将网络加载数据放入缓存中
    public static void setCache(String json, Context context, String url) {
        SpUtils.setString(context, url, json);
    }

    // 获取缓存 数据
    public static String getCache(Context context, String url) {

        return SpUtils.getString(context, url, null);
    }
}
