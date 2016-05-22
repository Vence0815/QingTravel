package com.vence.qingtravel.demon;

/**
 * Created by vence on 16/5/8 19:51
 * 邮箱 ：vence0815@foxmail.com
 */
public class BuyEvent {
    public MiaoSha miaoSha;
    public int position;

    public HomeData homeData;

    public DetailModel detailModel;

    public BuyEvent(MiaoSha miaoSha, int position) {
        this.miaoSha = miaoSha;
        this.position = position;
    }

    public BuyEvent(HomeData homeData, int position) {
        this.position = position;
        this.homeData = homeData;
    }

    public BuyEvent(DetailModel detailModel, int position) {
        this.detailModel = detailModel;
        this.position = position;
    }
}
