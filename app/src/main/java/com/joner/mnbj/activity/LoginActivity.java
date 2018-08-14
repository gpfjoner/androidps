package com.joner.mnbj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.joner.mnbj.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by gpfei on 2018/8/14.
 * 登陆界面
 */

public class LoginActivity extends Activity {
    @BindView(R.id.etname)
    EditText etname;
    @BindView(R.id.etpw)
    EditText etpw;
    @BindView(R.id.cb_RePwd)
    CheckBox cbRePwd;
    @BindView(R.id.tvLostPwd)
    Button tvLostPwd;
    @BindView(R.id.loginProgress)
    ProgressBar loginProgress;
    @BindView(R.id.login_btn)
    Button loginBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, LoginActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
        activity.finish();
    }

    @OnClick({R.id.tvLostPwd, R.id.login_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tvLostPwd:
                break;
            case R.id.login_btn:
                MainActivity.startAction(LoginActivity.this);
                break;
        }
    }
}
