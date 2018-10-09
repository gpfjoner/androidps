package com.joner.mnbj.weixinshare;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import static com.joner.mnbj.utils.Consts.WXSHARE_APP_ID;

/**
 * Created by gpfei on 2018/10/8.
 */

public class AppRegister extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        final IWXAPI api = WXAPIFactory.createWXAPI(context, null); // 将该app注册到微信
        api.registerApp(WXSHARE_APP_ID);
    }

    public interface OnResponseListener {
        //分享成功的回调
        void onSuccess();

        //分享取消的回调
        void onCancel();

        //分享失败的回调
        void onFail(String message);
    }

}