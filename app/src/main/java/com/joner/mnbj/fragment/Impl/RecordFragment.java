package com.joner.mnbj.fragment.Impl;

import android.content.Context;
import android.view.View;

import com.joner.mnbj.R;
import com.joner.mnbj.fragment.BaseFragment;

/**
 * Created by gpfei on 2018/8/13.
 */

public class RecordFragment extends BaseFragment {
    @Override
    public View initView() {
        View view  =  View.inflate(getContext(), R.layout.fragment_record,null);
        return view;
    }
}
