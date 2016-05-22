package com.vence.qingtravel.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.vence.qingtravel.R;
import com.vence.qingtravel.base.BasePager;
import com.vence.qingtravel.constent.Url;
import com.vence.qingtravel.demon.BuyEvent;
import com.vence.qingtravel.demon.DetailModel;
import com.vence.qingtravel.demon.HomeData;
import com.vence.qingtravel.demon.MiaoSha;
import com.vence.qingtravel.utils.CacheUtils;
import com.vence.qingtravel.utils.Loading;
import com.vence.qingtravel.volley.VolleyManager;

import org.greenrobot.eventbus.EventBus;
import org.xutils.x;

import java.util.List;

public class DetailActivity extends Activity {

    private ImageView iv_back;
    private ListView listView;
    private List<DetailModel.ListEntity> list;
    private DetailModel detailModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        listView = (ListView) findViewById(R.id.lv_detail);
        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        String miaosha = CacheUtils.getString(this, Url.DETAIL);
        if (!TextUtils.isEmpty(miaosha)) {
            presessData(new Gson().fromJson(miaosha, DetailModel.class));
        }
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DetailActivity.this, BuyDetailActivity.class);
                startActivity(intent);
                EventBus.getDefault().postSticky(new BuyEvent(detailModel,position));
            }
        });
        getDataFromServer();
    }


    private void getDataFromServer() {
        Loading.showLoading(DetailActivity.this);

        VolleyManager.newInstance().GsonGetRequest("TAG", Url.DETAIL, DetailModel.class, new Response.Listener<DetailModel>() {
            @Override
            public void onResponse(DetailModel response) {
                CacheUtils.putString(DetailActivity.this, Url.DETAIL, new Gson().toJson(response));
                presessData(response);
                Loading.dismissLoading();
                detailModel = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Loading.dismissLoading();
            }
        });
    }

    private void presessData(DetailModel response) {
        list = response.getList();
        listView.setAdapter(new MyAdapter());
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
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
                convertView = View.inflate(DetailActivity.this, R.layout.list_item_recomed, null);
                hoder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_item_icon);
                hoder.tv_title = (TextView) convertView.findViewById(R.id.tv_item_title);
                hoder.tv_score = (TextView) convertView.findViewById(R.id.tv_item_score);
                hoder.tv_number = (TextView) convertView.findViewById(R.id.tv_item_number);
                hoder.tv_price = (TextView) convertView.findViewById(R.id.tv_item_price);
                convertView.setTag(hoder);
            } else {
                hoder = (ViewHoder) convertView.getTag();
            }
            DetailModel.ListEntity listEntity = list.get(position);
            x.image().bind(hoder.iv_icon, listEntity.getImageUrl());
            hoder.tv_title.setText(listEntity.getLineName());
            hoder.tv_score.setText(listEntity.getScore());
            hoder.tv_number.setText(listEntity.getJoinpeoplenum());
            hoder.tv_price.setText(listEntity.getPresalePrice());
            return convertView;
        }

        class ViewHoder {
            ImageView iv_icon;
            TextView tv_title;
            TextView tv_score;
            TextView tv_number;
            TextView tv_price;
        }
    }
}
