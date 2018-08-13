
package com.joner.mnbj.activity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.joner.mnbj.R;
import com.joner.mnbj.activity.MainActivity;
import com.joner.mnbj.utils.Logger;
import com.joner.mnbj.view.CustomVideoView;
import com.joner.mnbj.widget.TimeCount;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.videoview)
    CustomVideoView videoview;
    @BindView(R.id.tvTimeClick)
    Button tvTimeClick;
    private TimeCount timeCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initView();
        initData();

    }

    private void initView() {
        //设置播放加载路径
        videoview.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video));
        //播放
        videoview.start();
        //循环播放
        videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                videoview.start();
            }
        });
    }

    private void initData() {
        timeCount = new TimeCount(5000, 1000, tvTimeClick, SplashActivity.this);
        timeCount.start();

        //timeCount.onFinish();
    }

    @OnClick(R.id.tvTimeClick)
    public void onViewClicked() {
        Logger.e("SplashActivity", "onViewClicked");
     //   timeCount.onFinish();
    }

    //返回重启加载
    @Override
    protected void onRestart() {
        initView();
        super.onRestart();
    }
}
