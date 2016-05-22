package com.vence.qingtravel.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.vence.qingtravel.MainActivity;
import com.vence.qingtravel.R;
import com.vence.qingtravel.demon.BuyEvent;
import com.vence.qingtravel.demon.DetailModel;
import com.vence.qingtravel.demon.HomeData;
import com.vence.qingtravel.demon.MiaoSha;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.xutils.x;

import java.util.List;

public class BuyDetailActivity extends Activity {
    private BuyEvent buyEvent;
    private ImageView iv_pic;
    private TextView title;
    private TextView from;
    private TextView price;
    private Button buind;
    private TextView chufa;
    private ImageView iv_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_detail);
        initView();
    }

    private void initView() {
        iv_pic = (ImageView) findViewById(R.id.iv_pic);
        title = (TextView) findViewById(R.id.tv_title);
        from = (TextView) findViewById(R.id.tv_from);
        price = (TextView) findViewById(R.id.tv_price);
        buind = (Button) findViewById(R.id.bund);
        chufa = (TextView) findViewById(R.id.tv_chufadi);
        iv_back = (ImageView) findViewById(R.id.iv_back);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        buind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(BuyDetailActivity.this)
                        .setTitle("预定提示")
                        .setMessage("您确定要预定本次行程吗？")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(BuyDetailActivity.this, "恭喜您预定成功", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .setNegativeButton("取消", null)
                        .show();
            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onEvent(BuyEvent buyEvent) {
        this.buyEvent = buyEvent;
        EventBus.getDefault().removeStickyEvent(buyEvent);

        initData();
    }

    private void initData() {
        if (buyEvent.miaoSha != null) {
            int position = buyEvent.position;
            MiaoSha.ListEntity listEntity = buyEvent.miaoSha.getList().get(position);
            x.image().bind(iv_pic, listEntity.getPic());
            title.setText(listEntity.getName());
            price.setText(listEntity.getNowprice());
            from.setText(listEntity.getDeparture());
        }
        if (buyEvent.homeData != null) {
            int position = buyEvent.position;
            List<HomeData.ThemeProductEntity.ThemeEntity> theme = buyEvent.homeData.getThemeProduct().getTheme();
            HomeData.ThemeProductEntity.ThemeEntity themeEntity = theme.get(position);
            chufa.setText("产品特色：");
            x.image().bind(iv_pic, themeEntity.getProductImgUrl());
            title.setText(themeEntity.getProductName());
            price.setText(themeEntity.getPrice());
            from.setText(themeEntity.getLabel());
        }

        if (buyEvent.detailModel != null) {
            int position = buyEvent.position;
            DetailModel.ListEntity listEntity = buyEvent.detailModel.getList().get(position);
            x.image().bind(iv_pic, listEntity.getImageUrl());
            title.setText(listEntity.getLineName());
            price.setText(listEntity.getPresalePrice());
            from.setText(listEntity.getDepartureName());

        }
    }

}
