package com.vence.qingtravel.adapter;

import android.app.Activity;
import android.content.Context;
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
 * Created by vence on 16/3/30 19:54
 * 邮箱 ：vence0815@foxmail.com
 */
public class TopBannerAdapter extends BaseAdapter {
    private Context context;
    private List<HomeData.MarketingActivitiesEntity.Position1Entity> topBanner;
    private final ImageOptions imageOptions;

    public TopBannerAdapter(Activity mActivity, List<HomeData.MarketingActivitiesEntity.Position1Entity> topBanner) {
        this.context = mActivity;
        this.topBanner = topBanner;

        imageOptions = new ImageOptions.Builder()
                .setSize(DensityUtil.dip2px(200), DensityUtil.dip2px(60))//图片大小
                .setRadius(DensityUtil.dip2px(8))//ImageView圆角半径
                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.FIT_XY)
                .setLoadingDrawableId(R.drawable.default_back)//加载中默认显示图片
                .setFailureDrawableId(R.drawable.default_back)//加载失败后默认显示图片
                .build();
    }

    @Override
    public int getCount() {
        return topBanner.size();
    }

    @Override
    public Object getItem(int position) {
        return topBanner.get(position);
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
            convertView = View.inflate(context, R.layout.topbanner_item, null);
            hoder.iv_icon = (ImageView) convertView.findViewById(R.id.iv_top_pic);
            hoder.tv_title = (TextView) convertView.findViewById(R.id.iv_top_title);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }

        final HomeData.MarketingActivitiesEntity.Position1Entity data = topBanner.get(position);

        x.image().bind(hoder.iv_icon, data.getPic(),imageOptions);
        hoder.tv_title.setText(data.getHeading());

        return convertView;
    }

    class ViewHoder {
        ImageView iv_icon;
        TextView tv_title;
    }

}
