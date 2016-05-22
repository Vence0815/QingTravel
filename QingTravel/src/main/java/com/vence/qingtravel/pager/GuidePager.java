package com.vence.qingtravel.pager;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.vence.qingtravel.R;
import com.vence.qingtravel.activity.DetailActivity;
import com.vence.qingtravel.base.BasePager;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

/**
 * Created by vence on 16/3/27 14:04
 * 邮箱 ：vence0815@foxmail.com
 * 分类导航
 */
public class GuidePager extends BasePager {

    @ViewInject(R.id.lv_guide)
    private ListView listView;

    private int[] img = {R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5, R.drawable.img6};
    private String[] discrpe = {"团队游", "自由行", "半自助", "小旅行", "游轮", "快速出行"};

    public GuidePager(Activity activity) {
        super(activity);
    }

    @Override
    public View getView() {
        View view = View.inflate(mActivity, R.layout.guidepager, null);
        x.view().inject(this, view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mActivity, DetailActivity.class);
                mActivity.startActivity(intent);
            }
        });
        return view;
    }

    @Override
    public void initData() {
        super.initData();

        listView.setAdapter(new MyAdapter());
    }


    class MyAdapter extends BaseAdapter {


        @Override
        public int getCount() {
            return img.length;
        }

        @Override
        public Object getItem(int position) {
            return img[position];
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
                convertView = View.inflate(mActivity, R.layout.guide_item, null);
                hoder.titile = (TextView) convertView.findViewById(R.id.tv_guide);
                hoder.imgs = (ImageView) convertView.findViewById(R.id.iv_guide);
                convertView.setTag(hoder);
            } else {
                hoder = (ViewHoder) convertView.getTag();
            }

            hoder.titile.setText(discrpe[position]);
            hoder.imgs.setImageResource(img[position]);

            return convertView;
        }

        class ViewHoder {
            TextView titile;
            ImageView imgs;
        }
    }

}