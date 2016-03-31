package com.example.zhao.mobilesafe.test.beans;

/**
 * Created by 赵涛 on 2016/3/31.
 */
public class UpdateJson {


    /**
     * result : 10000
     * message :
     * data : {"id":"35","self_add_version":"26","version":"2.2.0","url":"http://download.juntu.com/android/juntu.apk","message":"新版本说明：\r\n1.优惠券体验升级啦，首次登录成功即可领取优惠券红包\r\n2.酒店查看更简洁，支付更便捷，快速预订西安酒店，让你的旅行简单、放心\r\n3.新增西安近百家高品质、高性价比酒店，温泉度假酒店、豪华5星酒店轻松住","size":"11.6MB","is_update":"0"}
     */

    private int result;
    private String message;
    /**
     * id : 35
     * self_add_version : 26
     * version : 2.2.0
     * url : http://download.juntu.com/android/juntu.apk
     * message : 新版本说明：
     1.优惠券体验升级啦，首次登录成功即可领取优惠券红包
     2.酒店查看更简洁，支付更便捷，快速预订西安酒店，让你的旅行简单、放心
     3.新增西安近百家高品质、高性价比酒店，温泉度假酒店、豪华5星酒店轻松住
     * size : 11.6MB
     * is_update : 0
     */

    private DataBean data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String self_add_version;
        private String version;
        private String url;
        private String message;
        private String size;
        private String is_update;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSelf_add_version() {
            return self_add_version;
        }

        public void setSelf_add_version(String self_add_version) {
            this.self_add_version = self_add_version;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getIs_update() {
            return is_update;
        }

        public void setIs_update(String is_update) {
            this.is_update = is_update;
        }
    }
}
