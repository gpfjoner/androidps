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
import com.joner.mnbj.adapter.SimpleTreeListViewAdapter;
import com.joner.mnbj.bean.FileBean;
import com.joner.mnbj.fragment.BaseFragment;
import com.joner.mnbj.utils.tree.Node;

import java.util.ArrayList;
import java.util.List;

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
    private SimpleTreeListViewAdapter<Node> mAdapter;
    private List<Node> datas;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_record, null);
        return view;
    }

    @Override
    public void initData() throws IllegalAccessException {
        addData();//加入数据
        mAdapter = new SimpleTreeListViewAdapter<>(getActivity(), datas,1, lvMsgList);
    }

    private void addData() {
        datas = new ArrayList<Node>();
        Node node = new Node(1, 0, "目录1");
        datas.add(node);
        node = new Node(2, 0, "目录2");
        datas.add(node);
        node = new Node(3, 0, "目录3");
        datas.add(node);
        node = new Node(4, 1, "目录1-1");
        datas.add(node);
        node = new Node(5, 1, "目录1-2");
        datas.add(node);
        node = new Node(6, 2, "目录2-1");
        datas.add(node);
        node = new Node(7, 3, "目录3-1");
        datas.add(node);
        node = new Node(8, 7, "目录3-1-1");
        datas.add(node);
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
