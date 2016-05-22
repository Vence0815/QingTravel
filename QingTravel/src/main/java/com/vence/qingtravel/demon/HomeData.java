package com.vence.qingtravel.demon;

import java.util.List;

/**
 * Created by vence on 16/3/27 17:50
 * 邮箱 ：vence0815@foxmail.com
 */
public class HomeData {

    /**
     * code : 0
     * msg : 成功
     */

    private ResultmsgEntity resultmsg;
    /**
     * totalCount : 3
     * result : 1
     * activityInfo : [{"actId":"1940","heading":"神州专车优惠券","content":null,"actUrl":"http://mktm1.10101111.com/html5/2016/template_1/index.html?sharefrom=caissa80&tdaz=Jtsw1k&tdpg=hURdEh","actPicUrl":"http://app.img.caissa.com.cn/caissaImg/upload/cms/2016/3/25/1458907456661551761.jpg","lastModifyTime":"1458907836000","beginDate":"2016-03-25","endDate":"2016-04-30","bottomColor":"#123445"},{"actId":"1780","heading":"爸爸在海外","content":null,"actUrl":"http://www.wasu.cn/Play/show/id/7129097?refer=video.baidu.com","actPicUrl":"http://app.img.caissa.com.cn/caissaImg/upload/cms/2016/2/2/1454407391962490851.jpg","lastModifyTime":"1456902106000","beginDate":"2016-02-02","endDate":"2016-03-31","bottomColor":"#122345"},{"actId":"1760","heading":"奥运观赛产品开售","content":null,"actUrl":"66","actPicUrl":"http://app.img.caissa.com.cn/caissaImg/upload/cms/2016/1/26/1453798387378086581.jpg","lastModifyTime":"1456902111000","beginDate":"2016-01-26","endDate":"2016-03-31","bottomColor":"#123456"}]
     */

    private TopPageEntity topPage;
    private MarketingActivitiesEntity marketingActivities;
    /**
     * name : 凯撒到家
     * url : http://dj.caissa.com.cn/activity/smsk.html?from=caissaapp
     */

    private CassiaArriveHomeEntity cassiaArriveHome;
    /**
     * resultmsg : {"code":"0","msg":"成功"}
     * theme : [{"seqid":"13316","draftId":null,"status":"1","headTitle":null,"headUrl":null,"beginDate":"2016-03-22 00:00:00.0","endDate":"2016-04-15 00:00:00.0","acturl":null,"lastmodifytime":"2016-03-22 19:55:18.0","price":"17999","label":"优质航空,特色餐食,舒适住宿","scroe":"100","productImgUrl":"http://img.caissa.com.cn/201105/201105271411313910000.jpg","productName":"相聚灯光音乐节：星游澳洲-澳大利亚8日精致之旅（包含诺曼外堡礁）","scroeNum":"36","original":"18999","productLv":"2","productTheme":"rementuijian","productType":"1","exponentContent":null,"exponentNum":null,"productId":"349756","theriPage":"shouye","pagelistLocation":"01","place":"rementuijian","placeDate":"2016-05-28 ","channelids":"3","createtime":"2016-03-22 19:55:18.0","remarkLabel":null,"groupId":"67029"},{"seqid":"13315","draftId":null,"status":"1","headTitle":null,"headUrl":null,"beginDate":"2016-03-21 00:00:00.0","endDate":"2016-03-31 00:00:00.0","acturl":null,"lastmodifytime":"2016-03-22 19:48:36.0","price":"5588","label":"优质航空,特色餐食,舒适住宿","scroe":"99","productImgUrl":"http://img.caissa.com.cn/201105/201105261859132880000.jpg","productName":"花岛物语-巴厘岛7日芳香之旅","scroeNum":"683","original":"6388","productLv":"1","productTheme":"rementuijian","productType":"1","exponentContent":null,"exponentNum":null,"productId":"346372","theriPage":"shouye","pagelistLocation":"02","place":"rementuijian","placeDate":"2016-04-21 ","channelids":"3","createtime":"2016-03-21 12:44:51.0","remarkLabel":null,"groupId":"68117"},{"seqid":"13314","draftId":null,"status":"1","headTitle":null,"headUrl":null,"beginDate":"2016-03-21 00:00:00.0","endDate":"2016-03-31 00:00:00.0","acturl":null,"lastmodifytime":"2016-03-22 19:48:44.0","price":"3599","label":"","scroe":"98","productImgUrl":"http://imgs.caissa.com.cn/pic/M00/00/17/UEIoklQg2zbtUbSbAAEUPO7OgDs615-880-550.jpg","productName":"南纬8度-巴厘岛6日自助游（包机直飞+库塔宜必思酒店）","scroeNum":"376","original":"4299","productLv":"1","productTheme":"rementuijian","productType":"3","exponentContent":null,"exponentNum":null,"productId":"188868","theriPage":"shouye","pagelistLocation":"03","place":"rementuijian","placeDate":"2016-04-26 ","channelids":"3","createtime":"2016-03-21 12:40:58.0","remarkLabel":null,"groupId":null},{"seqid":"13307","draftId":null,"status":"1","headTitle":null,"headUrl":null,"beginDate":"2016-03-01 00:00:00.0","endDate":"2016-04-30 00:00:00.0","acturl":null,"lastmodifytime":"2016-03-22 19:48:28.0","price":"76999","label":"优质航空,特色餐食","scroe":"98","productImgUrl":"http://img.caissa.com.cn/201106/201106031148047150000.jpg","productName":"南美!南美!-巴西阿根廷智利秘鲁21日燃情之旅","scroeNum":"68","original":"99999","productLv":"2","productTheme":"rementuijian","productType":"1","exponentContent":null,"exponentNum":null,"productId":"347675","theriPage":"shouye","pagelistLocation":"04","place":"rementuijian","placeDate":"2016-06-08 ","channelids":"3","createtime":"2016-03-01 18:42:43.0","remarkLabel":null,"groupId":"64572"}]
     * totalCount : 4
     * currentPage : 1
     * limitCount : 4
     */

    private ThemeProductEntity themeProduct;

    public void setResultmsg(ResultmsgEntity resultmsg) {
        this.resultmsg = resultmsg;
    }

    public void setTopPage(TopPageEntity topPage) {
        this.topPage = topPage;
    }

    public void setMarketingActivities(MarketingActivitiesEntity marketingActivities) {
        this.marketingActivities = marketingActivities;
    }

    public void setCassiaArriveHome(CassiaArriveHomeEntity cassiaArriveHome) {
        this.cassiaArriveHome = cassiaArriveHome;
    }

    public void setThemeProduct(ThemeProductEntity themeProduct) {
        this.themeProduct = themeProduct;
    }

    public ResultmsgEntity getResultmsg() {
        return resultmsg;
    }

    public TopPageEntity getTopPage() {
        return topPage;
    }

    public MarketingActivitiesEntity getMarketingActivities() {
        return marketingActivities;
    }

    public CassiaArriveHomeEntity getCassiaArriveHome() {
        return cassiaArriveHome;
    }

    public ThemeProductEntity getThemeProduct() {
        return themeProduct;
    }

    public static class ResultmsgEntity {
        private String code;
        private String msg;

        public void setCode(String code) {
            this.code = code;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public String getCode() {
            return code;
        }

        public String getMsg() {
            return msg;
        }
    }

    public static class TopPageEntity {
        private String totalCount;
        private String result;
        /**
         * actId : 1940
         * heading : 神州专车优惠券
         * content : null
         * actUrl : http://mktm1.10101111.com/html5/2016/template_1/index.html?sharefrom=caissa80&tdaz=Jtsw1k&tdpg=hURdEh
         * actPicUrl : http://app.img.caissa.com.cn/caissaImg/upload/cms/2016/3/25/1458907456661551761.jpg
         * lastModifyTime : 1458907836000
         * beginDate : 2016-03-25
         * endDate : 2016-04-30
         * bottomColor : #123445
         */

        private List<ActivityInfoEntity> activityInfo;

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public void setResult(String result) {
            this.result = result;
        }

        public void setActivityInfo(List<ActivityInfoEntity> activityInfo) {
            this.activityInfo = activityInfo;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public String getResult() {
            return result;
        }

        public List<ActivityInfoEntity> getActivityInfo() {
            return activityInfo;
        }

        public static class ActivityInfoEntity {
            private String actId;
            private String heading;
            private Object content;
            private String actUrl;
            private String actPicUrl;
            private String lastModifyTime;
            private String beginDate;
            private String endDate;
            private String bottomColor;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setContent(Object content) {
                this.content = content;
            }

            public void setActUrl(String actUrl) {
                this.actUrl = actUrl;
            }

            public void setActPicUrl(String actPicUrl) {
                this.actPicUrl = actPicUrl;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getContent() {
                return content;
            }

            public String getActUrl() {
                return actUrl;
            }

            public String getActPicUrl() {
                return actPicUrl;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public String getBottomColor() {
                return bottomColor;
            }
        }
    }

    public static class MarketingActivitiesEntity {
        /**
         * actId : 1586
         * heading : 凯撒度假
         * subhead : null
         * pic : http://img.12580.com/ImagesUpload/upload/cms/2015/11/23/1448249500695311595.jpg
         * address : 不需要
         * beginDate : 2015-06-29
         * endDate : 2016-12-31
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #546c74
         * lastModifyTime : 2015-12-12 10:30:06
         * shareTitle : 凯撒度假
         * shareContent : null
         * sort : 1
         */

        private List<Position1Entity> position1;
        /**
         * actId : 1842
         * heading : 荷兰赏花全攻略│360°郁金香
         * subhead : by凯撒小编
         * pic : http://app.img.caissa.com.cn/caissaImg/upload/cms/2016/2/28/1456639606428800442.jpg
         * address : http://mp.weixin.qq.com/s?__biz=MzA4ODA4NTQwOA==&mid=402071315&idx=2&sn=e4cf16ccdb480b94d4cd8724d2bb46a3&scene=0#wechat_redirect
         * beginDate : 2016-02-28
         * endDate : 2016-03-31
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #123456
         * lastModifyTime : 2016-02-28 14:08:38
         * shareTitle : null
         * shareContent : null
         * sort : 1
         */

        private List<Position2Entity> position2;
        /**
         * actId : 1861
         * heading : 全世界最浮夸的甜点都在日本，没有之一
         * subhead : null
         * pic : http://app.img.caissa.com.cn/caissaImg/upload/cms/2016/3/4/1457090707028263435.jpg
         * address : http://mp.weixin.qq.com/s?__biz=MzA4ODA4NTQwOA==&mid=402102070&idx=5&sn=206e4c5d11b69e135620774e1f013dd7&scene=23&srcid=03047hSPczBstk1yVVCw3YfL#rd
         * beginDate : 2016-03-04
         * endDate : 2016-04-30
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #123456
         * lastModifyTime : 2016-03-04 19:27:28
         * shareTitle : null
         * shareContent : null
         * sort : 1
         */

        private List<Position3Entity> position3;
        /**
         * actId : 1302
         * heading : 明星线路
         * subhead : null
         * pic : http://img.12580.com/ImagesUpload/upload/cms/2015/8/10/1439189626949649603.png
         * address : http://apph5.caissa.com.cn/special/star/index.html
         * beginDate : 2015-08-10
         * endDate : 2016-08-10
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #999999
         * lastModifyTime : 2015-08-24 14:30:57
         * shareTitle : null
         * shareContent : null
         * sort : 1
         */

        private List<Position4Entity> position4;
        /**
         * actId : 1301
         * heading : 当季热卖
         * subhead : null
         * pic : http://img.12580.com/ImagesUpload/upload/cms/2015/8/11/1439256180424726253.png
         * address : http://apph5.caissa.com.cn/special/bestsell/index.html
         * beginDate : 2015-08-01
         * endDate : 2016-08-10
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #999999
         * lastModifyTime : 2016-02-16 10:21:56
         * shareTitle : null
         * shareContent : null
         * sort : 1
         */

        private List<Position5Entity> position5;
        /**
         * actId : 1309
         * heading : 秒杀抢购
         * subhead : null
         * pic : http://img.12580.com/ImagesUpload/upload/cms/2015/8/11/1439256325952549464.png
         * address : 不需要，跳转到原生页面即可
         * beginDate : 2015-08-01
         * endDate : 2016-08-10
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #999999
         * lastModifyTime : 2015-08-24 14:49:29
         * shareTitle : null
         * shareContent : null
         * sort : 1
         */

        private List<Position6Entity> position6;
        /**
         * actId : 1593
         * heading : 错峰出游
         * subhead : null
         * pic : http://img.12580.com/ImagesUpload/upload/cms/2015/11/23/1448247779272452315.jpg
         * address : http://apph5.caissa.com.cn/special/stagger/index.html
         * beginDate : 2015-12-12
         * endDate : 2016-12-31
         * reserved1 : null
         * reserved2 : null
         * bottomColor : #999999
         * lastModifyTime : 2016-01-29 15:00:54
         * shareTitle : 凯撒旅游-错峰出游产品
         * shareContent : null
         * sort : 1
         */

        private List<Position7Entity> position7;

        public void setPosition1(List<Position1Entity> position1) {
            this.position1 = position1;
        }

        public void setPosition2(List<Position2Entity> position2) {
            this.position2 = position2;
        }

        public void setPosition3(List<Position3Entity> position3) {
            this.position3 = position3;
        }

        public void setPosition4(List<Position4Entity> position4) {
            this.position4 = position4;
        }

        public void setPosition5(List<Position5Entity> position5) {
            this.position5 = position5;
        }

        public void setPosition6(List<Position6Entity> position6) {
            this.position6 = position6;
        }

        public void setPosition7(List<Position7Entity> position7) {
            this.position7 = position7;
        }

        public List<Position1Entity> getPosition1() {
            return position1;
        }

        public List<Position2Entity> getPosition2() {
            return position2;
        }

        public List<Position3Entity> getPosition3() {
            return position3;
        }

        public List<Position4Entity> getPosition4() {
            return position4;
        }

        public List<Position5Entity> getPosition5() {
            return position5;
        }

        public List<Position6Entity> getPosition6() {
            return position6;
        }

        public List<Position7Entity> getPosition7() {
            return position7;
        }

        public static class Position1Entity {
            private String actId;
            private String heading;
            private Object subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private String shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(Object subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }

        public static class Position2Entity {
            private String actId;
            private String heading;
            private String subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private Object shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(String subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(Object shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public String getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public Object getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }

        public static class Position3Entity {
            private String actId;
            private String heading;
            private Object subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private Object shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(Object subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(Object shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public Object getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }

        public static class Position4Entity {
            private String actId;
            private String heading;
            private Object subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private Object shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(Object subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(Object shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public Object getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }

        public static class Position5Entity {
            private String actId;
            private String heading;
            private Object subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private Object shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(Object subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(Object shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public Object getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }

        public static class Position6Entity {
            private String actId;
            private String heading;
            private Object subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private Object shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(Object subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(Object shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public Object getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }

        public static class Position7Entity {
            private String actId;
            private String heading;
            private Object subhead;
            private String pic;
            private String address;
            private String beginDate;
            private String endDate;
            private Object reserved1;
            private Object reserved2;
            private String bottomColor;
            private String lastModifyTime;
            private String shareTitle;
            private Object shareContent;
            private String sort;

            public void setActId(String actId) {
                this.actId = actId;
            }

            public void setHeading(String heading) {
                this.heading = heading;
            }

            public void setSubhead(Object subhead) {
                this.subhead = subhead;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setReserved1(Object reserved1) {
                this.reserved1 = reserved1;
            }

            public void setReserved2(Object reserved2) {
                this.reserved2 = reserved2;
            }

            public void setBottomColor(String bottomColor) {
                this.bottomColor = bottomColor;
            }

            public void setLastModifyTime(String lastModifyTime) {
                this.lastModifyTime = lastModifyTime;
            }

            public void setShareTitle(String shareTitle) {
                this.shareTitle = shareTitle;
            }

            public void setShareContent(Object shareContent) {
                this.shareContent = shareContent;
            }

            public void setSort(String sort) {
                this.sort = sort;
            }

            public String getActId() {
                return actId;
            }

            public String getHeading() {
                return heading;
            }

            public Object getSubhead() {
                return subhead;
            }

            public String getPic() {
                return pic;
            }

            public String getAddress() {
                return address;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getReserved1() {
                return reserved1;
            }

            public Object getReserved2() {
                return reserved2;
            }

            public String getBottomColor() {
                return bottomColor;
            }

            public String getLastModifyTime() {
                return lastModifyTime;
            }

            public String getShareTitle() {
                return shareTitle;
            }

            public Object getShareContent() {
                return shareContent;
            }

            public String getSort() {
                return sort;
            }
        }
    }

    public static class CassiaArriveHomeEntity {
        private String name;
        private String url;

        public void setName(String name) {
            this.name = name;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }

    public static class ThemeProductEntity {
        /**
         * code : 0
         * msg : 成功
         */

        private ResultmsgEntity resultmsg;
        private String totalCount;
        private String currentPage;
        private String limitCount;
        /**
         * seqid : 13316
         * draftId : null
         * status : 1
         * headTitle : null
         * headUrl : null
         * beginDate : 2016-03-22 00:00:00.0
         * endDate : 2016-04-15 00:00:00.0
         * acturl : null
         * lastmodifytime : 2016-03-22 19:55:18.0
         * price : 17999
         * label : 优质航空,特色餐食,舒适住宿
         * scroe : 100
         * productImgUrl : http://img.caissa.com.cn/201105/201105271411313910000.jpg
         * productName : 相聚灯光音乐节：星游澳洲-澳大利亚8日精致之旅（包含诺曼外堡礁）
         * scroeNum : 36
         * original : 18999
         * productLv : 2
         * productTheme : rementuijian
         * productType : 1
         * exponentContent : null
         * exponentNum : null
         * productId : 349756
         * theriPage : shouye
         * pagelistLocation : 01
         * place : rementuijian
         * placeDate : 2016-05-28
         * channelids : 3
         * createtime : 2016-03-22 19:55:18.0
         * remarkLabel : null
         * groupId : 67029
         */

        private List<ThemeEntity> theme;

        public void setResultmsg(ResultmsgEntity resultmsg) {
            this.resultmsg = resultmsg;
        }

        public void setTotalCount(String totalCount) {
            this.totalCount = totalCount;
        }

        public void setCurrentPage(String currentPage) {
            this.currentPage = currentPage;
        }

        public void setLimitCount(String limitCount) {
            this.limitCount = limitCount;
        }

        public void setTheme(List<ThemeEntity> theme) {
            this.theme = theme;
        }

        public ResultmsgEntity getResultmsg() {
            return resultmsg;
        }

        public String getTotalCount() {
            return totalCount;
        }

        public String getCurrentPage() {
            return currentPage;
        }

        public String getLimitCount() {
            return limitCount;
        }

        public List<ThemeEntity> getTheme() {
            return theme;
        }

        public static class ResultmsgEntity {
            private String code;
            private String msg;

            public void setCode(String code) {
                this.code = code;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getCode() {
                return code;
            }

            public String getMsg() {
                return msg;
            }
        }

        public static class ThemeEntity {
            private String seqid;
            private Object draftId;
            private String status;
            private Object headTitle;
            private Object headUrl;
            private String beginDate;
            private String endDate;
            private Object acturl;
            private String lastmodifytime;
            private String price;
            private String label;
            private String scroe;
            private String productImgUrl;
            private String productName;
            private String scroeNum;
            private String original;
            private String productLv;
            private String productTheme;
            private String productType;
            private Object exponentContent;
            private Object exponentNum;
            private String productId;
            private String theriPage;
            private String pagelistLocation;
            private String place;
            private String placeDate;
            private String channelids;
            private String createtime;
            private Object remarkLabel;
            private String groupId;

            public void setSeqid(String seqid) {
                this.seqid = seqid;
            }

            public void setDraftId(Object draftId) {
                this.draftId = draftId;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public void setHeadTitle(Object headTitle) {
                this.headTitle = headTitle;
            }

            public void setHeadUrl(Object headUrl) {
                this.headUrl = headUrl;
            }

            public void setBeginDate(String beginDate) {
                this.beginDate = beginDate;
            }

            public void setEndDate(String endDate) {
                this.endDate = endDate;
            }

            public void setActurl(Object acturl) {
                this.acturl = acturl;
            }

            public void setLastmodifytime(String lastmodifytime) {
                this.lastmodifytime = lastmodifytime;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public void setScroe(String scroe) {
                this.scroe = scroe;
            }

            public void setProductImgUrl(String productImgUrl) {
                this.productImgUrl = productImgUrl;
            }

            public void setProductName(String productName) {
                this.productName = productName;
            }

            public void setScroeNum(String scroeNum) {
                this.scroeNum = scroeNum;
            }

            public void setOriginal(String original) {
                this.original = original;
            }

            public void setProductLv(String productLv) {
                this.productLv = productLv;
            }

            public void setProductTheme(String productTheme) {
                this.productTheme = productTheme;
            }

            public void setProductType(String productType) {
                this.productType = productType;
            }

            public void setExponentContent(Object exponentContent) {
                this.exponentContent = exponentContent;
            }

            public void setExponentNum(Object exponentNum) {
                this.exponentNum = exponentNum;
            }

            public void setProductId(String productId) {
                this.productId = productId;
            }

            public void setTheriPage(String theriPage) {
                this.theriPage = theriPage;
            }

            public void setPagelistLocation(String pagelistLocation) {
                this.pagelistLocation = pagelistLocation;
            }

            public void setPlace(String place) {
                this.place = place;
            }

            public void setPlaceDate(String placeDate) {
                this.placeDate = placeDate;
            }

            public void setChannelids(String channelids) {
                this.channelids = channelids;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public void setRemarkLabel(Object remarkLabel) {
                this.remarkLabel = remarkLabel;
            }

            public void setGroupId(String groupId) {
                this.groupId = groupId;
            }

            public String getSeqid() {
                return seqid;
            }

            public Object getDraftId() {
                return draftId;
            }

            public String getStatus() {
                return status;
            }

            public Object getHeadTitle() {
                return headTitle;
            }

            public Object getHeadUrl() {
                return headUrl;
            }

            public String getBeginDate() {
                return beginDate;
            }

            public String getEndDate() {
                return endDate;
            }

            public Object getActurl() {
                return acturl;
            }

            public String getLastmodifytime() {
                return lastmodifytime;
            }

            public String getPrice() {
                return price;
            }

            public String getLabel() {
                return label;
            }

            public String getScroe() {
                return scroe;
            }

            public String getProductImgUrl() {
                return productImgUrl;
            }

            public String getProductName() {
                return productName;
            }

            public String getScroeNum() {
                return scroeNum;
            }

            public String getOriginal() {
                return original;
            }

            public String getProductLv() {
                return productLv;
            }

            public String getProductTheme() {
                return productTheme;
            }

            public String getProductType() {
                return productType;
            }

            public Object getExponentContent() {
                return exponentContent;
            }

            public Object getExponentNum() {
                return exponentNum;
            }

            public String getProductId() {
                return productId;
            }

            public String getTheriPage() {
                return theriPage;
            }

            public String getPagelistLocation() {
                return pagelistLocation;
            }

            public String getPlace() {
                return place;
            }

            public String getPlaceDate() {
                return placeDate;
            }

            public String getChannelids() {
                return channelids;
            }

            public String getCreatetime() {
                return createtime;
            }

            public Object getRemarkLabel() {
                return remarkLabel;
            }

            public String getGroupId() {
                return groupId;
            }
        }
    }
}
