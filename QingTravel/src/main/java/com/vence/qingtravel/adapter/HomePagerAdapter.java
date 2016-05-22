package com.vence.qingtravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vence.qingtravel.R;
import com.vence.qingtravel.demon.HomeData;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by vence on 16/3/27 19:58
 * 邮箱 ：vence0815@foxmail.com
 */
public class HomePagerAdapter extends BaseAdapter {
    private static final int ZHUTI_TRAVEL = 0;
    private static final int SHENGHUO = 1;
    private Context context;
    private HomeData homeData;
    private final List<HomeData.ThemeProductEntity.ThemeEntity> entityList;
    private final ImageOptions imageOptions;

    public HomePagerAdapter(Activity mActivity, HomeData homeData) {
        this.context = mActivity;
        this.homeData = homeData;
        //得到各种item的数据集合
        entityList = homeData.getThemeProduct().getTheme();

        imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(145), DensityUtil.dip2px(90))//图片大小
                .setRadius(DensityUtil.dip2px(10))//ImageView圆角半径
                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setLoadingDrawableId(R.drawable.default_back)//加载中默认显示图片
                .setFailureDrawableId(R.drawable.default_back)//加载失败后默认显示图片
                .build();

    }


    @Override
    public int getCount() {
        Log.e("TAG", entityList.size()+"");
        return entityList.size();
    }

    @Override
    public Object getItem(int position) {
        return entityList.get(position);
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
            convertView = View.inflate(context, R.layout.list_item_recomed, null);
            hoder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_item_icon);
            hoder.tv_title = (TextView) convertView.findViewById(R.id.tv_item_title);
            hoder.tv_score = (TextView) convertView.findViewById(R.id.tv_item_score);
            hoder.tv_number = (TextView) convertView.findViewById(R.id.tv_item_number);
            hoder.tv_price = (TextView) convertView.findViewById(R.id.tv_item_price);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }
        final HomeData.ThemeProductEntity.ThemeEntity entity = entityList.get(position);
        x.image().bind(hoder.iv_icon, entity.getProductImgUrl(),imageOptions);
        hoder.tv_title.setText(entity.getProductName());
        hoder.tv_score.setText(entity.getScroe());
        hoder.tv_number.setText(entity.getScroeNum());
        hoder.tv_price.setText(entity.getPrice());
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
