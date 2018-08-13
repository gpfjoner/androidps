package com.joner.mnbj.fragment.Impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.joner.mnbj.R;
import com.joner.mnbj.adapter.MineFragmentAdapter;
import com.joner.mnbj.fragment.BaseFragment;
import com.joner.mnbj.utils.Logger;
import com.zhy.autolayout.AutoRelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by gpfei on 2018/8/13.
 */

public class MineFragment extends BaseFragment implements AdapterView.OnItemClickListener {

    Unbinder unbinder;
    @BindView(R.id.tvName)
    TextView tvName;
    @BindView(R.id.tvUserOrgan)
    TextView tvUserOrgan;
    @BindView(R.id.mineBar)
    AutoRelativeLayout mineBar;
    @BindView(R.id.lvInfor)
    ListView lvInfor;
    @BindView(R.id.ivLogoutPic)
    ImageView ivLogoutPic;
    @BindView(R.id.tvLogout)
    TextView tvLogout;
    @BindView(R.id.rlBtn)
    AutoRelativeLayout rlBtn;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_mine, null);
        return view;
    }

    @Override
    public void initData() {
        String[] msgInfor = getContext().getResources().getStringArray(R.array.infor_user_msg);
        MineFragmentAdapter mineFragmentAdapter = new MineFragmentAdapter(msgInfor, getContext());
        lvInfor.setAdapter(mineFragmentAdapter);
        lvInfor.setOnItemClickListener(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.rlBtn)
    public void onViewClicked(View view) {
        Logger.e(TAG, "onViewClicked");
    }

    private void showShare() {
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // title标题，微信、QQ和QQ空间等平台使用
        oks.setTitle(getString(R.string.share));
        // titleUrl QQ和QQ空间跳转链接
        oks.setTitleUrl("http://sharesdk.cn");
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url在微信、微博，Facebook等平台中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网使用
        oks.setComment("我是测试评论文本");
        // 启动分享GUI
        oks.show(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
                break;
            case 4:
                showShare();
                break;
        }
    }
}
}
