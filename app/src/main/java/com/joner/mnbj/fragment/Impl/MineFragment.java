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


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position) {
            case 0:
            case 1:
            case 2:
            case 3:
                break;
            case 4:
                break;
        }
    }
}

