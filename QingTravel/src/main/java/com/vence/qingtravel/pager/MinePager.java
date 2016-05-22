package com.vence.qingtravel.pager;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.vence.qingtravel.activity.LoginActivity;
import com.vence.qingtravel.R;
import com.vence.qingtravel.base.BasePager;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by vence on 16/3/27 14:04
 * 邮箱 ：vence0815@foxmail.com
 * 个人中心，用户登录注册信息
 */
public class MinePager extends BasePager {

    @ViewInject(R.id.et_username)
    private EditText et_username;

    @ViewInject(R.id.et_pwd)
    private EditText et_pwd;

    @ViewInject(R.id.btn_login)
    private Button btn_login;

    @ViewInject(R.id.tv_regist)
    private TextView tv_regist;

    public MinePager(Activity activity) {
        super(activity);
    }

    @Override
    public View getView() {
        View view = View.inflate(mActivity, R.layout.login, null);
        x.view().inject(this, view);

        clickListener();
        return view;
    }

    /**
     * 按钮的点击事件
     */
    private void clickListener() {
        tv_regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, LoginActivity.class);
                mActivity.startActivity(intent);
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }
}
