package com.joner.mnbj.fragment.Impl;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.joner.mnbj.R;
import com.joner.mnbj.adapter.SimpleTreeListViewAdapter;
import com.joner.mnbj.bean.FileBean;
import com.joner.mnbj.fragment.BaseFragment;
import com.joner.mnbj.utils.Logger;
import com.joner.mnbj.utils.ToastUtils;
import com.joner.mnbj.utils.tree.Node;
import com.joner.mnbj.utils.tree.TreeListAdapter;

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
    private SimpleTreeListViewAdapter<FileBean> mAdapter;
    private List<FileBean> datas;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_record, null);
        return view;
    }

    @Override
    public void initData() throws IllegalAccessException {
        addData();//加入数据
        //Logger.e(TAG, "" + datas.size() + " msg:" + datas.get(0).getDesc());
        mAdapter = new SimpleTreeListViewAdapter<>(getActivity(), datas, 1, lvMsgList);
        lvMsgList.setAdapter(mAdapter);
        //点击事件
        mAdapter.setOnTreeClickListener(new TreeListAdapter.OnTreeNodeClickListener() {
            @Override
            public void onClick(Node node, int position) {
                if (node.isLeaf()) {
                    ToastUtils.show(getContext(), node.getName(), false);
                }
            }
        });
        lvMsgList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                // ToastUtils.show(getActivity(),"长按显示",false);
                final EditText et = new EditText(getContext());
                new AlertDialog.Builder(getContext()).setTitle("插入").setView(et).setPositiveButton("sure", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (TextUtils.isEmpty(et.getText().toString())){
                            ToastUtils.show(getActivity(),"不能为空",false);
                            return;
                        }
                        mAdapter.addExtraNode(position, et.getText().toString());

                    }
                }).setNegativeButton("no", null).show();
                //false 双触发。true
                return true;
            }
        });
    }

    private void addData() {
        datas = new ArrayList<FileBean>();
        FileBean node = new FileBean(1, 0, "目录1");
        datas.add(node);
        node = new FileBean(2, 0, "目录2");
        datas.add(node);
        node = new FileBean(3, 0, "目录3");
        datas.add(node);
        node = new FileBean(4, 1, "目录1-1");
        datas.add(node);
        node = new FileBean(5, 2, "目录2-1");
        datas.add(node);
        node = new FileBean(6, 2, "目录2-2");
        datas.add(node);
        node = new FileBean(7, 3, "目录3-1");
        datas.add(node);
        node = new FileBean(8, 7, "目录3-1-1");
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
