package com.vence.qingtravel;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.vence.qingtravel.base.BasePager;
import com.vence.qingtravel.pager.GuidePager;
import com.vence.qingtravel.pager.HomePager;
import com.vence.qingtravel.pager.MinePager;
import com.vence.qingtravel.pager.TravelPager;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final int EXIT = 1;
    @ViewInject(R.id.rg_main)
    private RadioGroup rg_main;

    private List<BasePager> mPagers;
    private int mPosition;
    private String city ="杭州";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        x.view().inject(this);
        city = getIntent().getStringExtra("city");
        initData();
    }

    /*
    初始化化界面数据
     */
    private void initData() {
        mPagers = new ArrayList<>();
        mPagers.add(new HomePager(this,city));
        mPagers.add(new GuidePager(this));
        mPagers.add(new TravelPager(this));
        mPagers.add(new MinePager(this));
        rg_main.setOnCheckedChangeListener(new MyOnCheckChanged());
        rg_main.check(R.id.rb_home);//默认首页选中
    }

    class MyOnCheckChanged implements RadioGroup.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                default:
                    mPosition = 0;
                    break;
                case R.id.rb_guide:
                    mPosition = 1;
                    break;
                case R.id.rb_travel:
                    mPosition = 2;
                    break;
                case R.id.rb_mine:
                    mPosition = 3;
                    break;
            }
            //得到下标后设置相应的页面
            setFragment();
        }
    }

    /**
     * 设置相应的页面
     */
    private void setFragment() {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fl_mian_content, new Fragment() {
            @Override
            public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
                BasePager basepager = getBasePager();
                if (null != basepager) {
                    return basepager.mRootView;
                }
                return null;
            }
        }).commit();
    }

    /**
     * 获取相应的界面
     *
     * @return
     */
    private BasePager getBasePager() {
        BasePager basepager = mPagers.get(mPosition);//没有点击的时候有可能为空
        if (null != basepager && !basepager.isInit) {//防止空指针
            basepager.isInit = true;
            basepager.initData();//不用重复调用initData方法
        }
        return basepager;
    }

    boolean isEsit = false;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case EXIT:
                    isEsit = false;
                    break;
            }
        }
    };

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {

        if (KeyEvent.KEYCODE_BACK == keyCode) {
            if (0 != mPosition) {
                rg_main.check(R.id.rb_home);//按退出的时候回到首页的位置
                return true;
            } else if (!isEsit) {
                Toast.makeText(this, "再按一次退出！", Toast.LENGTH_SHORT).show();
                isEsit = true;
                handler.sendEmptyMessageDelayed(EXIT, 2000);
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        super.onDestroy();
    }

}
