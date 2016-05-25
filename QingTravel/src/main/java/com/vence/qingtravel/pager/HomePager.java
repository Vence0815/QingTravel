package com.vence.qingtravel.pager;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.vence.qingtravel.MainActivity;
import com.vence.qingtravel.R;
import com.vence.qingtravel.activity.BuyDetailActivity;
import com.vence.qingtravel.activity.CityListActivity;
import com.vence.qingtravel.activity.DetailActivity;
import com.vence.qingtravel.activity.SearchAcy;
import com.vence.qingtravel.adapter.HeadViewPagerAdapter;
import com.vence.qingtravel.adapter.HomePagerAdapter;
import com.vence.qingtravel.adapter.MiaoShaAdapter;
import com.vence.qingtravel.adapter.TopBannerAdapter;
import com.vence.qingtravel.base.BasePager;
import com.vence.qingtravel.constent.Url;
import com.vence.qingtravel.demon.AddressEvent;
import com.vence.qingtravel.demon.BuyEvent;
import com.vence.qingtravel.demon.HomeData;
import com.vence.qingtravel.demon.MiaoSha;
import com.vence.qingtravel.demon.ResultAddressEvent;
import com.vence.qingtravel.utils.CacheUtils;
import com.vence.qingtravel.view.NoScrollGridView;
import com.vence.qingtravel.view.NoScrollListView;
import com.vence.qingtravel.volley.VolleyManager;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.common.util.DensityUtil;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by vence on 16/3/27 14:04
 * 邮箱 ：vence0815@foxmail.com
 * 主页
 */
public class HomePager extends BasePager implements View.OnClickListener {

    private List<HomeData.TopPageEntity.ActivityInfoEntity> topViePagerInfo;

    @ViewInject(R.id.tv_top_hot)
    private TextView tv_top_hot;

    @ViewInject(R.id.tv_top_search)
    private TextView tv_top_search;

    @ViewInject(R.id.lv_home)
    private NoScrollListView lv_home;

    @ViewInject(R.id.vp_head)
    private ViewPager vp_head;

    @ViewInject(R.id.gv_banner)
    private NoScrollGridView gv_banner;

    @ViewInject(R.id.gv_miaosha)
    private NoScrollGridView gv_miaosha;

    @ViewInject(R.id.pull_refresh)
    private PullToRefreshScrollView pull_refresh;

    @ViewInject(R.id.ll_point)
    private LinearLayout ll_point;

    @ViewInject(R.id.tv_location)
    private TextView tv_location;//定位的城市

    @ViewInject(R.id.img_mine)
    private ImageView img_mine;

    private String city;

    private InternalHandler internalHandler;

    private MiaoSha miaoSha;

    private HomeData homeData;

    private List<HomeData.MarketingActivitiesEntity.Position1Entity> topBanner;


    public HomePager(Activity activity, String city) {
        super(activity);
        this.city = city;

        EventBus.getDefault().register(this);

    }


    @Override
    public View getView() {
        View view = View.inflate(mActivity, R.layout.home_pager, null);
        x.view().inject(this, view);

        pull_refresh.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ScrollView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ScrollView> refreshView) {
                getDataFromServce();
            }
        });

        /**
         * 顶部搜索和推荐的点击事件
         */
        tv_top_hot.setOnClickListener(this);
        tv_top_search.setOnClickListener(this);
        //设置默认的选项

        setListener();
        gv_banner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, DetailActivity.class);
                mActivity.startActivity(intent);
            }
        });

        gv_miaosha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, BuyDetailActivity.class);
                mActivity.startActivity(intent);
                EventBus.getDefault().postSticky(new BuyEvent(miaoSha, position));
            }
        });

        lv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, BuyDetailActivity.class);
                mActivity.startActivity(intent);
                EventBus.getDefault().postSticky(new BuyEvent(homeData, position));
            }
        });
        return view;
    }

    /**
     * 给视图添加各种监听
     */
    private void setListener() {
        tv_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mActivity, CityListActivity.class);
                mActivity.startActivityForResult(intent, Activity.RESULT_OK);
            }
        });

        img_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mActicity = (MainActivity) mActivity;
                mActicity.setCurrentFragment(3);
            }
        });
    }


    private int prePosition;

    class MyPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            //把上一次高亮显示的设置为默认
            ll_point.getChildAt(prePosition).setEnabled(false);

            //把当前位置对应的点设置高亮
            ll_point.getChildAt(position).setEnabled(true);
            //记录高亮过的位置
            prePosition = position;
        }

        private boolean isDragging = false;

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {
            if (state == ViewPager.SCROLL_STATE_DRAGGING) {
                System.out.println("SCROLL_STATE_DRAGGING");
                isDragging = true;
                if (internalHandler != null) {
                    internalHandler.removeCallbacksAndMessages(null);
                }
            } else if (state == ViewPager.SCROLL_STATE_IDLE && isDragging) {
                isDragging = false;

                System.out.println("SCROLL_STATE_IDLE");
                if (internalHandler != null) {
                    internalHandler.removeCallbacksAndMessages(null);
                    internalHandler.postDelayed(new MyRunnable(), 4000);
                }
            } else if (state == ViewPager.SCROLL_STATE_SETTLING && isDragging) {
                isDragging = false;
                System.out.println("SCROLL_STATE_SETTLING");
                if (internalHandler != null) {
                    internalHandler.removeCallbacksAndMessages(null);
                    internalHandler.postDelayed(new MyRunnable(), 4000);
                }
            }
        }
    }

    @Override
    public void initData() {
        super.initData();

        final String homeData = CacheUtils.getString(mActivity, Url.HOME);
        if (!TextUtils.isEmpty(homeData)) {
            prcessData(new Gson().fromJson(homeData, HomeData.class));
        }

        String miaosha = CacheUtils.getString(mActivity, Url.MIAO_SHA);
        if (!TextUtils.isEmpty(miaosha)) {
            prcessMishaoData(new Gson().fromJson(miaosha, MiaoSha.class));
        }
        getDataFromServce();
    }

    /**
     * 从服务器获取数据
     */
    private void getDataFromServce() {
        VolleyManager.newInstance().GsonGetRequest("TAG", Url.HOME, HomeData.class,
                new Response.Listener<HomeData>() {
                    @Override
                    public void onResponse(HomeData response) {
                        Log.e("TAG", "联网成功" + response.toString());
                        prcessData(response);
                        homeData = response;
                        CacheUtils.putString(mActivity, Url.HOME, new Gson().toJson(response));
                        pull_refresh.onRefreshComplete();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "联网失败" + error.toString());
                        pull_refresh.onRefreshComplete();
                    }
                });


        VolleyManager.newInstance().GsonGetRequest("TAG", Url.MIAO_SHA, MiaoSha.class,
                new Response.Listener<MiaoSha>() {
                    @Override
                    public void onResponse(MiaoSha response) {
                        Log.e("TAG", "秒杀联网成功" + response.toString());
                        prcessMishaoData(response);
                        miaoSha = response;
                        CacheUtils.putString(mActivity, Url.MIAO_SHA, new Gson().toJson(response));
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("TAG", "秒杀联网失败" + error.toString());
                    }
                });


    }

    /**
     * 处理秒杀的数据
     *
     * @param miaoSha
     */
    private void prcessMishaoData(MiaoSha miaoSha) {
        gv_miaosha.setAdapter(new MiaoShaAdapter(mActivity, miaoSha));
    }

    /**
     * 得到数据，
     *
     * @param homeData
     */
    private void prcessData(HomeData homeData) {
        topViePagerInfo = homeData.getTopPage().getActivityInfo();//头部viewpager的数据

        topBanner = homeData.getMarketingActivities().getPosition1();//viewpager下面的部分


        gv_banner.setAdapter(new TopBannerAdapter(mActivity, topBanner));
        lv_home.setAdapter(new HomePagerAdapter(mActivity, homeData));

        vp_head.setAdapter(new HeadViewPagerAdapter(mActivity, topViePagerInfo));

        vp_head.addOnPageChangeListener(new MyPageChangeListener());

        addPoint();//添加轮播图圆点

        //开始循环顶部的轮播图循环播放
        if (internalHandler == null) {
            internalHandler = new InternalHandler();
        } else {
            internalHandler.removeCallbacksAndMessages(null);//把消息队列的所有回调和消息移除，在onDestory的时候调用
        }

        internalHandler.postDelayed(new MyRunnable(), 3000);
    }


    /**
     * 添加轮播图圆点
     */
    private void addPoint() {
        //移除所有的点
        ll_point.removeAllViews();
        //设置红点
        for (int i = 0; i < topViePagerInfo.size(); i++) {
            ImageView point = new ImageView(mActivity);
            point.setBackgroundResource(R.drawable.tabdetail_point_selector);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(DensityUtil.dip2px(8), DensityUtil.dip2px(8));
            point.setLayoutParams(params);

            if (i == 0) {
                point.setEnabled(true);
            } else {
                params.leftMargin = 8;
                point.setEnabled(false);
            }

            //把点添加到线性布局里面
            ll_point.addView(point);
        }
    }

    class MyRunnable implements Runnable {

        @Override
        public void run() {
            internalHandler.sendEmptyMessage(0);
        }
    }

    class InternalHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int item = (vp_head.getCurrentItem() + 1) % topViePagerInfo.size();
            vp_head.setCurrentItem(item);

            //循环起来
            internalHandler.postDelayed(new MyRunnable(), 3000);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_top_hot://头部热门
                tv_top_hot.setSelected(true);
                tv_top_search.setSelected(false);
                break;
            case R.id.tv_top_search://头部搜索框
                tv_top_hot.setSelected(false);
                tv_top_search.setSelected(true);
                Intent intent = new Intent(mActivity, SearchAcy.class);
                mActivity.startActivity(intent);

                break;
        }
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(AddressEvent addressEvent) {
        EventBus.getDefault().removeStickyEvent(addressEvent);
        String city = addressEvent.city;
        if (!city.isEmpty()) {
            tv_location.setText(city);
        }
    }

    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(ResultAddressEvent resultAddressEvent) {
        EventBus.getDefault().removeStickyEvent(resultAddressEvent);
        String city = resultAddressEvent.cityName;
        if (!city.isEmpty()) {
            tv_location.setText(city);
        }
    }


}
