package com.joner.mnbj.fragment.Impl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.TranslateAnimation;

import com.joner.mnbj.R;
import com.joner.mnbj.entity.CircularDataEntity;
import com.joner.mnbj.fragment.BaseFragment;
import com.joner.mnbj.view.CircularExhibitionView;

import java.util.ArrayList;

/**
 * Created by gpfei on 2018/8/13.
 * 统计操作
 */

public class StatisticsFragment extends BaseFragment {

    private CircularExhibitionView circularExhibitionView;


    @Override
    public View initView() {
        View view = View.inflate(getContext(), R.layout.fragment_statistics, null);
        circularExhibitionView = view.findViewById(R.id.circular);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        CircularDataEntity entity = new CircularDataEntity();
        entity.setArcName("test");
        entity.setArcPercent(0.3f);
        entity.setBackColor(Color.RED);
        entity.setTextColor(Color.BLUE);
        CircularDataEntity entity1 = new CircularDataEntity();
        entity1.setArcName("Hello");
        entity1.setArcPercent(0.5f);
        entity1.setBackColor(Color.GREEN);
        entity1.setTextColor(Color.BLACK);
        CircularDataEntity entity2 = new CircularDataEntity();
        entity2.setArcName("Hello");
        entity2.setArcPercent(0.2f);
        entity2.setBackColor(Color.BLUE);
        entity2.setTextColor(Color.WHITE);
        ArrayList<CircularDataEntity> data = new ArrayList<>();
        data.add(entity);
        data.add(entity1);
        data.add(entity2);
        circularExhibitionView.setData(data);

    }
}
