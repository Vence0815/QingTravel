package com.vence.qingtravel.demon;

import java.io.Serializable;
import java.util.List;

/**
 * Created by vence on 16/3/30 19:03
 * 邮箱 ：vence0815@foxmail.com
 */
public class MiaoSha implements Serializable{

    /**
     * code : 0
     * msg : 成功
     */

    private ResultmsgEntity resultmsg;
    /**
     * resultmsg : {"code":"0","msg":"成功"}
     * list : [{"lineid":"349941","groupid":"67403","name":"【北京出发】奥法意瑞11日之旅","price":"12088","nowprice":"11088","date":"2016-05-09","num":"10","pic":"http://img.caissa.com.cn/201105/201105291805494900000.jpg","departure":"北京"},{"lineid":"350454","groupid":"67774","name":"【北京出发】父母感恩季：东欧11日健康老人之旅","price":"15488","nowprice":"14488","date":"2016-05-09","num":"2","pic":"http://img.caissa.com.cn/201107/201107281400185770000.jpg","departure":"北京"}]
     * count : 2
     */

    private String count;
    /**
     * lineid : 349941
     * groupid : 67403
     * name : 【北京出发】奥法意瑞11日之旅
     * price : 12088
     * nowprice : 11088
     * date : 2016-05-09
     * num : 10
     * pic : http://img.caissa.com.cn/201105/201105291805494900000.jpg
     * departure : 北京
     */

    private List<ListEntity> list;

    public void setResultmsg(ResultmsgEntity resultmsg) {
        this.resultmsg = resultmsg;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public ResultmsgEntity getResultmsg() {
        return resultmsg;
    }

    public String getCount() {
        return count;
    }

    public List<ListEntity> getList() {
        return list;
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

    public static class ListEntity {
        private String lineid;
        private String groupid;
        private String name;
        private String price;
        private String nowprice;
        private String date;
        private String num;
        private String pic;
        private String departure;

        public void setLineid(String lineid) {
            this.lineid = lineid;
        }

        public void setGroupid(String groupid) {
            this.groupid = groupid;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setNowprice(String nowprice) {
            this.nowprice = nowprice;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public void setNum(String num) {
            this.num = num;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public void setDeparture(String departure) {
            this.departure = departure;
        }

        public String getLineid() {
            return lineid;
        }

        public String getGroupid() {
            return groupid;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getNowprice() {
            return nowprice;
        }

        public String getDate() {
            return date;
        }

        public String getNum() {
            return num;
        }

        public String getPic() {
            return pic;
        }

        public String getDeparture() {
            return departure;
        }
    }
}
