package com.vence.qingtravel.base;

import android.app.Activity;
import android.view.View;

/**
 * Created by vence on 16/3/27 13:39
 * 邮箱 ：vence0815@foxmail.com
 * 所有页面的基类
 */
public abstract class BasePager {
    public Activity mActivity;
    public View mRootView;
    public boolean isInit;

    public BasePager(Activity activity) {
        mActivity = activity;
        mRootView = getView();
    }

    protected BasePager() {
    }

    public abstract View getView();

    public void initData() {

    }
}
