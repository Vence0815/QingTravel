package com.vence.qingtravel.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.vence.qingtravel.R;
import com.vence.qingtravel.database.UserInforDao;
import com.vence.qingtravel.demon.UserInfor;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;


public class LoginActivity extends Activity implements View.OnClickListener {

    @ViewInject(R.id.et_number)
    private EditText et_number;

    @ViewInject(R.id.btn_send)
    private Button btn_send;

    @ViewInject(R.id.iv_back)
    private ImageView iv_back;

    @ViewInject(R.id.btn_submit)
    private Button btn_submit;

    @ViewInject(R.id.et_yanzheng)
    private EditText et_yanzheng;
    private ProgressDialog dialog;

    @ViewInject(R.id.et_password)
    private EditText et_pwd;

    private EventHandler ev = new EventHandler() {
        @Override
        public void afterEvent(int event, int result, Object data) {
            if (result == SMSSDK.RESULT_COMPLETE) {
                //回调完成
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
                    //提交验证码成功
                    Log.e("TAG", "提交验证码成功" + data.toString());

                    HashMap<String, Object> mData = (HashMap<String, Object>) data;
                    String country = (String) mData.get("country");//返回的国家编号
                    final String phone = (String) mData.get("phone");//返回用户注册的手机号

                    Log.e("TAG", country + "====" + phone);

                    if (phone.equals(number)) {
                        runOnUiThread(new Runnable() {//更改ui的操作要放在主线程，实际可以发送hander
                            @Override
                            public void run() {
                                showDailog("恭喜你！通过验证");
                                dialog.dismiss();
                                //    Toast.makeText(MainActivity.this, "通过验证", Toast.LENGTH_SHORT).show();
                                UserInforDao dao = new UserInforDao(LoginActivity.this);
                                UserInfor userInfor = new UserInfor();
                                String s = et_pwd.getText().toString();
                                userInfor.setPassWord(s);
                                userInfor.setUserName(phone);
                                dao.adduserInfor(userInfor);
                            }
                        });
                    } else {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                showDailog("验证失败");
                                dialog.dismiss();
                                //     Toast.makeText(MainActivity.this, "验证失败", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }


                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    //获取验证码成功
                    Log.e("TAG", "获取验证码成功");
                } else if (event == SMSSDK.EVENT_GET_SUPPORTED_COUNTRIES) {
                    //返回支持发送验证码的国家列表
                }
            } else {
                ((Throwable) data).printStackTrace();
            }
        }
    };
    private String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        x.view().inject(this);


        SMSSDK.registerEventHandler(ev); //注册短信回调
        btn_send.setOnClickListener(this);
        iv_back.setOnClickListener(this);
        btn_submit.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                number = et_number.getText().toString().trim();
                //发送短信，传入国家号和电话
                SMSSDK.getVerificationCode("+86", number);
                Toast.makeText(this, "发送成功" + number, Toast.LENGTH_SHORT).show();
                break;
            case R.id.iv_back:
                finish();
                break;
            case R.id.btn_submit:
                String yanzheng = et_yanzheng.getText().toString();
                //String country, String phone, String code
                //提交短信验证码
                dialog = ProgressDialog.show(this, null, "正在验证...", false, true);
                SMSSDK.submitVerificationCode("+86", number, yanzheng);//国家号，号码，验证码
                Toast.makeText(this, "提交注册信息" + number, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void showDailog(String text) {
        new AlertDialog.Builder(this)
                .setTitle(text)
                .setPositiveButton("确定", null)
                .show();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //要在
        SMSSDK.unregisterAllEventHandler();
    }
}
