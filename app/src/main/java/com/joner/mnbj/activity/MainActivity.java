package com.joner.mnbj.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.joner.mnbj.R;
import com.joner.mnbj.fragment.Impl.MineFragment;
import com.joner.mnbj.fragment.Impl.RecordFragment;
import com.joner.mnbj.fragment.Impl.StatisticsFragment;
import com.joner.mnbj.utils.ClickUtils;
import com.joner.mnbj.utils.Consts;
import com.joner.mnbj.utils.Logger;
import com.joner.mnbj.utils.SpUtils;
import com.joner.mnbj.utils.ToastUtils;
import com.pgyersdk.crash.PgyCrashManager;
import com.zhy.autolayout.AutoLinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by gpfei on 2018/8/9.
 */

public class MainActivity extends FragmentActivity {


    @BindView(R.id.contentPanel)
    FrameLayout contentPanel;
    @BindView(android.R.id.tabcontent)
    FrameLayout tabcontent;
    @BindView(android.R.id.tabhost)
    FragmentTabHost tabhost;
    private LayoutInflater mIndicator;
    private AutoLinearLayout mTabindicatorlayout;
    private String TAG = getClass().getSimpleName();
    private long exitTime;

    /* 开启跳转*/
    public static void startAction(Activity activity) {
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.fade_in,
                R.anim.fade_out);
        activity.finish();
    }

    private Class fragmentArray[] = {RecordFragment.class, StatisticsFragment.class, MineFragment.class};
    private String mTextviewArray[] = {"one", "two", "three"};
    private int mTitleArray[] = {R.string.one, R.string.two, R.string.three};
    private int mImageViewArray[] = {R.drawable.selector_btn_one, R.drawable.selector_btn_two, R.drawable.selector_btn_mine};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PgyCrashManager.register(this);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initData() {
        for (int i = 0; i < mTitleArray.length; i++) {
            //为每一个Tab按钮设置图标、文字和内容
            TabHost.TabSpec tabSpec = tabhost.newTabSpec(mTextviewArray[i]).setIndicator(getTabItemView(i));
            //将Tab按钮添加进Tab选项卡中
            tabhost.addTab(tabSpec, fragmentArray[i], null);
            tabhost.getTabWidget().setDividerDrawable(null);
        }

    }

    private void initView() {
        tabhost.setup(this, getSupportFragmentManager(), R.id.contentPanel);
        mIndicator = LayoutInflater.from(this);

    }

    private View getTabItemView(int index) {
        View view = mIndicator.inflate(R.layout.tab_indicator, null);
        ImageView icon = view.findViewById(R.id.icon_tab);
        mTabindicatorlayout = view.findViewById(R.id.tabindicatorlayout);
        icon.setImageResource(mImageViewArray[index]);
        TextView title = view.findViewById(R.id.txt_indicator);
        title.setText(mTitleArray[index]);
        return view;
    }


    /*点击2次退出应用 间隔小于2秒*/
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

            if (ClickUtils.isFastClick())  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                ToastUtils.show(getApplicationContext(), getResources().getString(R.string.toast_login_again), Toast.LENGTH_SHORT);
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.e(TAG,"MainActivity onDestroy ");
        PgyCrashManager.unregister();
    }
}
