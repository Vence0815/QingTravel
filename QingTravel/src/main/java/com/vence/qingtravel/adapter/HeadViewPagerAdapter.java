package com.vence.qingtravel.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.vence.qingtravel.R;
import com.vence.qingtravel.demon.HomeData;

import org.xutils.image.ImageOptions;
import org.xutils.x;

import java.util.List;

/**
 * Created by vence on 16/3/27 21:49
 * 邮箱 ：vence0815@foxmail.com
 */
public class HeadViewPagerAdapter extends PagerAdapter {
    private Context context;
    private List<HomeData.TopPageEntity.ActivityInfoEntity> topViePagerInfo;
    private ImageOptions imageOptions;
    private int[] icon= {R.drawable.banner1,R.drawable.banner1,R.drawable.banner1};

    public HeadViewPagerAdapter(Context context, List<HomeData.TopPageEntity.ActivityInfoEntity> topViePagerInfo) {
        this.context = context;
        this.topViePagerInfo = topViePagerInfo;

        imageOptions = new ImageOptions.Builder()
           //     .setSize(DensityUtil.dip2px(145), DensityUtil.dip2px(90))//图片大小
                        //      .setRadius(DensityUtil.dip2px(10))//ImageView圆角半径
                .setCrop(true)// 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                .setLoadingDrawableId(R.drawable.default_back)//加载中默认显示图片
                .setFailureDrawableId(R.drawable.default_back)//加载失败后默认显示图片
                .build();
    }

    @Override
    public int getCount() {
        return topViePagerInfo.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
       HomeData.TopPageEntity.ActivityInfoEntity infoEntity = topViePagerInfo.get(position);

        ImageView imageView = new ImageView(context);
    //    imageView.setImageResource(icon[position]);
        x.image().bind(imageView, infoEntity.getActPicUrl(), imageOptions);
        //   imageView.setImageResource(R.drawable.test);
        container.addView(imageView);
        return imageView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
