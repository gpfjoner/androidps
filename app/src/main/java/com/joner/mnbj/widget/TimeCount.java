package com.joner.mnbj.widget;

import android.app.Activity;
import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;

import com.joner.mnbj.activity.MainActivity;
import com.joner.mnbj.activity.SplashActivity;

/**
 * Created by gpfei on 2018/6/8.
 */

public class TimeCount extends CountDownTimer {

    private Button btn_count;
    private Activity context;



    public TimeCount(long millisInFuture, long countDownInterval, Button btn_count ,Activity context) {
        super(millisInFuture, countDownInterval);
        this.btn_count = btn_count;
        this.context = context;
    }

    @Override
    public void onTick(long millisUntilFinished) {
      //  btn_count.setEnabled(false);
        btn_count.setText(millisUntilFinished / 1000 + "秒");
    }

    @Override
    public void onFinish() {
       // btn_count.setEnabled(true);
        MainActivity.startAction(context);
    }

}