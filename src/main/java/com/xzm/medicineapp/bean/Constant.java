package com.xzm.medicineapp.bean;

import java.util.Arrays;
import java.util.List;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-02-07 10:01
 */
public class Constant {

    /**
     * 星座相关常量
     */
    public static List<String> CONSTELLATIONSTRLIST = Arrays.asList("双鱼座", "白羊座", "金牛座", "双子座",
            "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座");

    /**
     * 星座请求的url
     */
    public static String CONSTELLATIONURL = "http://web.juhe.cn:8080/constellation/getAll";

    /**
     * 星座在redis存储时间，单位为小时
     */
    public static Integer CONSTELLATIONTTL = 10;

    public enum ConstellationParam {

        TYPE("type", "today"),
        KEY("key", "6f99d04702c95adfc2c354dfede407b0");

        private String key;
        private String value;

        ConstellationParam(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}
