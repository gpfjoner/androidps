package com.joner.mnbj.fragment.Impl;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.joner.mnbj.R;
import com.joner.mnbj.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by gpfei on 2018/8/13.
 * 记账类
 */

public class RecordFragment extends BaseFragment {
    @BindView(R.id.rbMoneyIn)
    RadioButton rbMoneyIn;
    @BindView(R.id.rbMoneyOut)
    RadioButton rbMoneyOut;
    @BindView(R.id.lvMsgList)
    ListView lvMsgList;
    Unbinder unbinder;

    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_record, null);
        return view;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.rbMoneyIn, R.id.rbMoneyOut})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rbMoneyIn:
                break;
            case R.id.rbMoneyOut:
                break;
        }
    }
}
