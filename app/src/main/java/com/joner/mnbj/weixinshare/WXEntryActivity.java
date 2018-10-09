package com.joner.mnbj.weixinshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.joner.mnbj.R;
import com.joner.mnbj.utils.ToastUtils;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 与微信交互的类
 */
public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {

    @BindView(R.id.btn_pyq)
    Button btnPyq;
    @BindView(R.id.btn_hy)
    Button btnHy;
    private IWXAPI api;
    private WXShare wxShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxentry);
        ButterKnife.bind(this);
        wxShare = new WXShare(this);
        wxShare.setListener(new AppRegister.OnResponseListener() {
            @Override
            public void onSuccess() {
                ToastUtils.show(WXEntryActivity.this, "onSuccess", false);

            }

            @Override
            public void onCancel() {
                ToastUtils.show(WXEntryActivity.this, "onCancel", false);
            }

            @Override
            public void onFail(String message) {
                ToastUtils.show(WXEntryActivity.this, "onFail", false);
            }
        });
        Log.e("WXEntryActivity", "WXEntryActivity");
       // WXShare share = new WXShare(this);
        api = wxShare.getApi();
        //判断是否安装了微信
        if (!Tools.isAppAvilible(WXEntryActivity.this, "com.tencent.mm")) {
            ToastUtils.show(WXEntryActivity.this, "您还没有安装微信", false);
            //this.finish();
            return;
        } else {


            wxShare.share("这是要分享的文字");
            // wxShare.shareUrl(0, this, "https://open.weixin.qq.com", "微信分享", getResources().getString(R.string.WXShareStr));
            //注意：
            // 第三方开发者如果使用透明界面来实现WXEntryActivity，
            // 需要判断handleIntent的返回值，如果返回值为false，
            // 则说明入参不合法未被SDK处理，应finish当前透明界面，避
            // 免外部通过传递非法参数的Intent导致停留在透明界面，
            // 引起用户的疑惑
            try {
                if (!api.handleIntent(getIntent(), this)) {
                    finish();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        wxShare.register();
    }

    @Override
    protected void onDestroy() {
        wxShare.unregister();
        super.onDestroy();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e("onNewIntent", "onNewIntent");
        setIntent(intent);
        if (!api.handleIntent(intent, this)) {
            finish();
        }
    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        Intent intent = new Intent(WXShare.ACTION_SHARE_RESPONSE);
        intent.putExtra(WXShare.EXTRA_RESULT, new WXShare.Response(baseResp));
        sendBroadcast(intent);
        finish();
    }

    @OnClick({R.id.btn_pyq, R.id.btn_hy})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_pyq:
                //朋友圈
                wxShare.shareUrl(1,this,"https://www.pgyer.com/Z1uO","分享到微信朋友圈","测试一下");
                break;
            case R.id.btn_hy:
                wxShare.shareUrl(0,this,"https://www.pgyer.com/Z1uO","分享给微信好友","测试一下");
                //好友
                break;
        }
    }
}


