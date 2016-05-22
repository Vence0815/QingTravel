package com.vence.qingtravel;

import android.app.Activity;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.vence.qingtravel.service.LocationService;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

public class SplashActivity extends Activity {
    @ViewInject(R.id.rl_splah)
    private RelativeLayout rl_splah;
    private Handler handler = new Handler();
    private String city;
    private LocationService locationService;
    public Vibrator mVibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        x.view().inject(this);

        locationService = new LocationService(getApplicationContext());
        mVibrator = (Vibrator) getApplicationContext().getSystemService(Service.VIBRATOR_SERVICE);

        locationService.start();// 定位SDK
        //显示动画
        showAnimation(rl_splah);
    }

    private void showAnimation(RelativeLayout rl_splah) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0, 1);
        alphaAnimation.setDuration(1000);
        alphaAnimation.setFillAfter(true);
        rl_splah.startAnimation(alphaAnimation);
        //延迟启动mainactivity
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startMain();
            }
        }, 3000);
    }

    private void startMain() {
        Intent intent = new Intent(this, MainActivity.class);
        if (city == null) {
            Toast.makeText(this, "获取位置信息失败", Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        } else {
            intent.putExtra("city", city);
            Toast.makeText(this, "已自动定位到当前城市：" + city, Toast.LENGTH_SHORT).show();
            startActivity(intent);
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
    }

    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            city = bdLocation.getCity();
        }
    };

    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }
}
