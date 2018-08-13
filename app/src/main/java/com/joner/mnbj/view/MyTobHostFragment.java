package com.joner.mnbj.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by gpfei on 2018/7/30.
 */

public class MyTobHostFragment extends android.support.v4.app.FragmentTabHost {
    private OnTabClickListener mOnTabClickListener = null;
    private boolean isClickLinstener = false;

    public MyTobHostFragment(Context context) {
        super(context);
    }

    public MyTobHostFragment(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onTabChanged(String tabId) {
        if (null != mOnTabClickListener) {
            isClickLinstener = mOnTabClickListener.onTabClick(tabId);
        }

        if (!isClickLinstener) {
            super.onTabChanged(tabId);
        }
    }


    public void setOnTabClickListener(OnTabClickListener mOnTabClickListener) {
        this.mOnTabClickListener = mOnTabClickListener;
    }


    public interface OnTabClickListener {
        /**
         * If you set the click event, according to the return value of the click event to determine whether to continue to perform
         *
         * @param tabId tabId
         * @return true：Interception event；false：Superclass continue
         */
        boolean onTabClick(String tabId);
    }

}
