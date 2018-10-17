package com.joner.mnbj.fragment.Impl;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;

import com.joner.mnbj.R;
import com.joner.mnbj.adapter.AccountBookAdapter;
import com.joner.mnbj.entity.AccountBookEntity;
import com.joner.mnbj.utils.tree.SimpleTreeListViewAdapter;
import com.joner.mnbj.utils.tree.bean.FileBean;
import com.joner.mnbj.fragment.BaseFragment;
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

    @BindView(R.id.detail_list)
    RecyclerView detailList;

    @BindView(R.id.load_btn)
    View saveView;

    Unbinder unbinder;
    private AccountBookAdapter accountBookAdapter;
    private ArrayList<AccountBookEntity> datas;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_record, null);
        return view;
    }

    @Override
    public void initData() throws IllegalAccessException {
        addData();//加入数据
        accountBookAdapter = new AccountBookAdapter(getActivity(), datas);

        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayout.VERTICAL);

        detailList.setLayoutManager(manager);
        detailList.setAdapter(accountBookAdapter);

    }

    private void addData() {
        datas = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            AccountBookEntity entity = new AccountBookEntity();
            for (int j = 0; j <= i + 1; j++) {
                AccountBookEntity entity1 = new AccountBookEntity();
                entity1.setContent("工资收入收入收入收入收入收入收入收入");
                entity1.setMoney(100 + j * 10);
                entity1.setDate("1999.09.09");
                entity.getChildDetail().add(entity1);
            }
            datas.add(entity);
        }
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


}
