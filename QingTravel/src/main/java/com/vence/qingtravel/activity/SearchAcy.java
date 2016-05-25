package com.vence.qingtravel.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.MessageQueue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.vence.qingtravel.R;
import com.vence.qingtravel.constent.Url;
import com.vence.qingtravel.demon.DetailModel;
import com.vence.qingtravel.utils.CacheUtils;
import com.vence.qingtravel.utils.Loading;
import com.vence.qingtravel.volley.VolleyManager;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.body.StringBody;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class SearchAcy extends Activity {

    @ViewInject(R.id.img_back)
    private ImageView back;

    @ViewInject(R.id.et_search)
    private EditText etSearch;

    @ViewInject(R.id.txt_serarch)
    private TextView tvSearch;

    @ViewInject(R.id.lv_serach)
    private ListView listView;

    @ViewInject(R.id.tv_hint)
    private TextView tv_hint;
    private MyAdapter adapter;
    private List<DetailModel.ListEntity> list;
    private ProgressDialog pd;
    private ProgressDialog show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_acy);
        x.view().inject(this);
        adapter = new MyAdapter();

        setListenre();
    }

    /**
     * 设置监听
     */
    private void setListenre() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        tvSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDataFromServer();

            }


        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });

    }


    /**
     * 从网络上获取数据
     */
    private void getDataFromServer() {

        String keyword = etSearch.getText().toString();
        if (keyword.isEmpty()) {
            Toast.makeText(SearchAcy.this, "请输入你要搜索的关键词", Toast.LENGTH_SHORT).show();
        } else {
            show = ProgressDialog.show(this, null, "正在搜索中...", true);

            VolleyManager.newInstance().GsonGetRequest("TAG", Url.DETAIL + keyword, DetailModel.class, new Response.Listener<DetailModel>() {
                @Override
                public void onResponse(DetailModel response) {
                    //           Loading.dismissLoading();
                    processData(response);
                    show.dismiss();
                }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    //           Loading.dismissLoading();
                    show.dismiss();
                }
            });
        }
    }


    /**
     * 处理得到的数据
     *
     * @param response
     */
    private void processData(DetailModel response) {
        list = response.getList();
        View view = findViewById(R.id.rl_empt);
        listView.setAdapter(adapter);
        listView.setEmptyView(view);
        show.dismiss();
    }

    public class MyAdapter extends BaseAdapter {
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
                convertView = View.inflate(SearchAcy.this, R.layout.list_item_recomed, null);
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
