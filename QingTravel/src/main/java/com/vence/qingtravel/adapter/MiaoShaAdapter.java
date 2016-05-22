package com.vence.qingtravel.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.vence.qingtravel.R;
import com.vence.qingtravel.demon.MiaoSha;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by vence on 16/3/30 19:12
 * 邮箱 ：vence0815@foxmail.com
 */
public class MiaoShaAdapter extends BaseAdapter {
    private Context context;
    private MiaoSha miaoSha;
    private final List<MiaoSha.ListEntity> list;
    private ImageOptions imageOptions;

    public MiaoShaAdapter(Activity mActivity, MiaoSha miaoSha) {
        this.context = mActivity;
        this.miaoSha = miaoSha;
        list = miaoSha.getList();
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
            convertView = View.inflate(context, R.layout.miaosha_item, null);
            hoder.iv_miaosha_pic = (ImageView) convertView.findViewById(R.id.iv_miaosha_pic);
            hoder.tv_miaosha_title = (TextView) convertView.findViewById(R.id.tv_miaosha_title);
            hoder.tv_miaosha_time = (TextView) convertView.findViewById(R.id.tv_miaosha_time);
            hoder.tv_miaosha_prise = (TextView) convertView.findViewById(R.id.tv_miaosha_prise);
            convertView.setTag(hoder);
        } else {
            hoder = (ViewHoder) convertView.getTag();
        }

        final MiaoSha.ListEntity listEntity = list.get(position);

        x.image().bind(hoder.iv_miaosha_pic, listEntity.getPic());
        hoder.tv_miaosha_title.setText(listEntity.getName());
        hoder.tv_miaosha_time.setText("出发时间 " + listEntity.getDate());
        hoder.tv_miaosha_prise.setText("￥" + listEntity.getPrice());

        return convertView;
    }

    class ViewHoder {
        ImageView iv_miaosha_pic;
        TextView tv_miaosha_title;
        TextView tv_miaosha_time;
        TextView tv_miaosha_prise;

    }
}
