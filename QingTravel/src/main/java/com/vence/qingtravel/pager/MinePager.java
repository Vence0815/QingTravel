package com.vence.qingtravel.pager;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.vence.qingtravel.activity.LoginActivity;
import com.vence.qingtravel.R;
import com.vence.qingtravel.base.BasePager;
import com.vence.qingtravel.database.UserInforDao;
import com.vence.qingtravel.demon.UserInfor;

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

    @ViewInject(R.id.rl_login_success)
    private RelativeLayout rl_success;

    @ViewInject(R.id.ll_login)
    private LinearLayout ll_login;

    @ViewInject(R.id.tv_username)
    private TextView tv_username;

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

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = et_username.getText().toString();
                String pwd = et_pwd.getText().toString();

                UserInforDao dao = new UserInforDao(mActivity);
                UserInfor userInfor = dao.loginSelect(name);
                if (userInfor != null && userInfor.getPassWord().equals(pwd)) {//登录成功后
                    rl_success.setVisibility(View.VISIBLE);
                    ll_login.setVisibility(View.GONE);
                    Toast.makeText(mActivity, "恭喜你登录成功！", Toast.LENGTH_SHORT).show();
                    tv_username.setText("尊敬的：" + userInfor.getUserName() + "用户，恭喜你登录成功！");
                } else {//登录失败
                    Toast.makeText(mActivity, "登录名或者密码不正确", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void initData() {
        super.initData();
    }
}
