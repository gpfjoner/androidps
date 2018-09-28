package com.joner.mnbj.activity.mine;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.joner.mnbj.R;
import com.joner.mnbj.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class OtherForMineActivity extends AppCompatActivity {

    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tvPayMoney)
    TextView tvPayMoney;
    @BindView(R.id.pay_weixin)
    RadioButton payWeixin;
    @BindView(R.id.pay_zhifubo)
    RadioButton payZhifubo;
    @BindView(R.id.iv_pay_pic)
    ImageView ivPayPic;
    @BindView(R.id.tv_upMsg)
    TextView tvUpMsg;
    @BindView(R.id.etDescribe)
    EditText etDescribe;
    @BindView(R.id.btn_msg)
    Button btnMsg;
    @BindView(R.id.btn_back)
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_for_mine);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_share, R.id.tvPayMoney, R.id.pay_weixin, R.id.pay_zhifubo, R.id.btn_msg, R.id.btn_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_share:
                ToastUtils.show(OtherForMineActivity.this, "share", false);
                break;
            case R.id.tvPayMoney:
               // ToastUtils.show(OtherForMineActivity.this, "tvPayMoney", false);
                break;
            case R.id.pay_weixin:
                ToastUtils.show(OtherForMineActivity.this, "pay_weixin", false);
                ivPayPic.setImageDrawable(getApplication().getDrawable(R.drawable.weixin_pay));
                break;
            case R.id.pay_zhifubo:
                ToastUtils.show(OtherForMineActivity.this, "pay_zhifubo", false);
                ivPayPic.setImageDrawable(getApplication().getDrawable(R.drawable.zhifubo_pay));
                break;
            case R.id.btn_msg:
                ToastUtils.show(OtherForMineActivity.this, "信息提交成功！", false);
                this.finish();
                break;
            case R.id.btn_back:
                ToastUtils.show(OtherForMineActivity.this, "btn_back", false);
                this.finish();
                break;
        }
    }
}
