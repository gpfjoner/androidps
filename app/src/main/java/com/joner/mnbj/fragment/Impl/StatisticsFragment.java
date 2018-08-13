package com.joner.mnbj.fragment.Impl;

import android.view.View;

import com.joner.mnbj.R;
import com.joner.mnbj.fragment.BaseFragment;

/**
 * Created by gpfei on 2018/8/13.
 */

public class StatisticsFragment extends BaseFragment {
    @Override
    public View initView() {
        View view  =  View.inflate(getContext(), R.layout.fragment_statistics,null);
        return view;
    }
}
