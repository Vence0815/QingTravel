package com.vence.qingtravel.pager;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.vence.qingtravel.R;
import com.vence.qingtravel.activity.TravelRecond;
import com.vence.qingtravel.base.BasePager;
import com.vence.qingtravel.constent.Url;
import com.vence.qingtravel.demon.TravelData;
import com.vence.qingtravel.utils.Sputils;

import org.xutils.common.Callback;
import org.xutils.common.util.DensityUtil;
import org.xutils.http.RequestParams;
import org.xutils.image.ImageOptions;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

/**
 * Created by vence on 16/3/27 14:04
 * 邮箱 ：vence0815@foxmail.com
 * 游记
 */
public class TravelPager extends BasePager {


    @ViewInject(R.id.lv_travel)
    private PullToRefreshListView lv_travel;
    private List<TravelData.DataEntity> data;
    private TravelAdapter adapter;
    private ImageOptions imageOptions;

    public TravelPager(Activity activity) {
        super(activity);
    }

    @Override
    public View getView() {
        View view = View.inflate(mActivity, R.layout.travel_recode, null);
        x.view().inject(this, view);

        lv_travel.setMode(PullToRefreshBase.Mode.BOTH);
        lv_travel.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                getDataFromServer();
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                getMoreDataFromServer();
            }
        });
        /*lv_travel.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener<ListView>() {
            @Override
            public void onRefresh(PullToRefreshBase<ListView> refreshView) {
                if (lv_travel.isHeaderShown()) {//下拉刷新

                } else {//下拉加载更多

                }
            }
        });*/

        ListView listView = lv_travel.getRefreshableView();
        listView.setOnItemClickListener(new MyOnItemClickListener());
        return view;
    }

    class MyOnItemClickListener implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Log.e("TAG", "position" + position);
            TravelData.DataEntity dataEntity = data.get(position-1);
            String viewUrl = dataEntity.getView_url();
            Intent intent = new Intent(mActivity, TravelRecond.class);
            intent.putExtra("url", viewUrl);
            mActivity.startActivity(intent);
        }
    }

    @Override
    public void initData() {
        super.initData();

        imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(145), DensityUtil.dip2px(90))//图片大小
                .setRadius(DensityUtil.dip2px(6))//ImageView圆角半径
                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setLoadingDrawableId(R.drawable.default_back)//加载中默认显示图片
                .setFailureDrawableId(R.drawable.default_back)//加载失败后默认显示图片
                .build();
        String catchs = Sputils.getInstance(mActivity).get(Url.TRAVEL_BASE + "1" + Url.TRAVEL_COUNT, null);
        if (!TextUtils.isEmpty(catchs)) {
            processData(catchs);
        }
        getDataFromServer();
    }

    /**
     * 获取网络数据
     */
    private void getDataFromServer() {
        RequestParams params = new RequestParams(Url.TRAVEL_BASE + "1" + Url.TRAVEL_COUNT);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "获取数据成功" + result);
                processData(result);
                Sputils.getInstance(mActivity).save(Url.TRAVEL_BASE + "1" + Url.TRAVEL_COUNT, result);
                lv_travel.onRefreshComplete();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "连接失败" + ex.toString());
                lv_travel.onRefreshComplete();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 加载更多
     */
    private int i = 1;

    private void getMoreDataFromServer() {
        i++;
        //      Log.e("TAG", "加载的页数====" + i);
        RequestParams params = new RequestParams(Url.TRAVEL_BASE + i + Url.TRAVEL_COUNT);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Log.e("TAG", "获取数据成功" + result);
                processMoreData(result);
                lv_travel.onRefreshComplete();
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                Log.e("TAG", "连接失败" + ex.toString());
                lv_travel.onRefreshComplete();
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        });
    }

    /**
     * 处理加载更多
     *
     * @param result
     */
    private void processMoreData(String result) {
        TravelData travelData = parseJson(result);
        List<TravelData.DataEntity> mData = travelData.getData();
        data.addAll(mData);
        adapter.notifyDataSetChanged();
    }


    /**
     * 处理json数据，并设置数据
     *
     * @param result
     */
    private void processData(String result) {
        TravelData travelData = parseJson(result);
        data = travelData.getData();

        adapter = new TravelAdapter();
        lv_travel.setAdapter(adapter);
    }


    /**
     * 解析json
     *
     * @param result
     * @return
     */
    private TravelData parseJson(String result) {
        return new Gson().fromJson(result, TravelData.class);
    }

    class TravelAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHoder hoder = null;
            if (convertView == null) {
                hoder = new ViewHoder();
                convertView = View.inflate(mActivity, R.layout.travel_item, null);
                hoder.iv_pic = (ImageView) convertView.findViewById(R.id.iv_travel_icon);
                hoder.tv_title = (TextView) convertView.findViewById(R.id.tv_travel_title);
                hoder.tv_audio = (TextView) convertView.findViewById(R.id.tv_audio);
                hoder.tv_views = (TextView) convertView.findViewById(R.id.tv_views);
                hoder.tv_commons = (TextView) convertView.findViewById(R.id.tv_commons);
                convertView.setTag(hoder);
            } else {
                hoder = (ViewHoder) convertView.getTag();
            }
            TravelData.DataEntity dataEntity = data.get(position);
            x.image().bind(hoder.iv_pic, dataEntity.getPhoto(), imageOptions);
            hoder.tv_title.setText(dataEntity.getTitle());

            hoder.tv_audio.setText(dataEntity.getUsername());
            hoder.tv_views.setText(dataEntity.getViews() + "");
            hoder.tv_commons.setText(dataEntity.getReplys());
            return convertView;
        }

        class ViewHoder {
            ImageView iv_pic;
            TextView tv_title;
            TextView tv_audio;
            TextView tv_views;
            TextView tv_commons;
        }
    }
}
