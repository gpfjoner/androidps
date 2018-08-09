package com.joner.mnbj.utils;

import android.content.Context;
import android.widget.Toast;
/*
*   弹框Utils 类
*
*/

public class ToastUtils {
    private static Toast toast;

    public static void show(Context context, String msg, int lengthShort) {
        show(context, msg, false);
    }

    public static void show(Context context, String msg, boolean durationLong) {

        int duration;
        if (durationLong) {
            duration = Toast.LENGTH_LONG;
        } else {
            duration = Toast.LENGTH_SHORT;
        }
        //防止频繁TOAST。用户体验差问题
        if (toast == null) {
            toast = Toast.makeText(context, msg, duration);
        } else {
            toast.setText(msg);
        }
        toast.show();
    }
}
