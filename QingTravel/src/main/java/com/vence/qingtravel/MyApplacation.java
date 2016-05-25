package com.vence.qingtravel;

import android.app.Application;
import android.content.Context;

import com.baidu.mapapi.SDKInitializer;
import com.vence.qingtravel.demon.UserModel;
import com.vence.qingtravel.service.WriteLog;

import org.xutils.x;

import cn.smssdk.SMSSDK;

/**
 * Created by vence on 16/3/27 13:50
 * 邮箱 ：vence0815@foxmail.co
 * 初始化工具类
 */
public class MyApplacation extends Application {
    private static Context sContext;
    public UserModel userModel;
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
        sContext = getApplicationContext();

        WriteLog.getInstance().init(); // 初始化日志
        SDKInitializer.initialize(getApplicationContext());
        //初始化短信验证
        SMSSDK.initSDK(this, "1124c69a57768", "0fe9540545157623cd2156f75a769f70");
        userModel = new UserModel();

    }

    public static Context getContext() {
        return sContext;
    }
}


