package com.vence.qingtravel.constent;

/**
 * Created by vence on 16/3/27 16:59
 * 邮箱 ：vence0815@foxmail.com
 * 各个网页链接的工具类
 */
public class Url {

    /**
     * 限时秒杀
     */
    public static final String MIAO_SHA = "http://appsever.caissa.com.cn/api/groupTour/querySeckill?comId=178&page=1&pageSize=2&ver=2.0";

    /**
     * 首页数据
     */
    public static final String HOME = "http://appsever.caissa.com.cn/api/msg/queryMarketActivity?channelIds=3";

    /**
     * 旅行游记
     */
    public static final String TRAVEL_BASE = "http://open.qyer.com/qyer/recommands/trip?client_id=qyer_android&client_secret=9fcaae8aefc4f9ac4915&v=1&track_deviceid=863970026797852&track_app_version=6.8.5&track_app_channel=xiaomi" +
            "&track_device_info=pisces&track_os=Android4.4.4&app_installtime=1459442971874&type=index&page=";

    public static final String TRAVEL_COUNT = "&count=10";

    //得到城市列表的数据
    public static final String CITY_LIST = "http://api.m.mtime.cn/Showtime/HotCitiesByCinema.api";

    /**
     * 列表详情
     */
    public static final String DETAIL = "http://appsever.caissa.com.cn/api/groupTour/serachGroupTravleList?companyid=178&ps=10&pn=1&lineContinentid=&destinationcountryid=&lineDays=&orderBy=&lineDeparture=&isuitableFor=&lineType=&isHoliday=&isQualityFlight=&isSmallGroup=&isWifi=&isSale=&isDiscount=&depmonth=&lineLevel=&queryKey=";
}

