package com.xzm.medicineapp;

import com.alibaba.fastjson.JSON;
import com.xzm.medicineapp.bean.Constellation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.DigestUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineappApplicationTests {

    @Autowired
    @Qualifier("myRedisTemplate")
    private RedisTemplate redisTemplate;

    private static List<String> constellationStrList = Arrays.asList("双鱼座", "白羊座", "金牛座", "双子座",
            "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座");

    @Test
    public void contextLoads() {
        List<Constellation> constellationList = new ArrayList<>();
        for (String str : constellationStrList) {
            String res = (String) redisTemplate.opsForValue().get(str);
            if (res != null) {
                Constellation constellation = JSON.parseObject(res, Constellation.class);
                constellationList.add(constellation);
            }
        }
        System.out.println(constellationList.toString());
    }

    @Test
    public void test02() {
        Set<String> constellationStrList = redisTemplate.keys("*座");
        List<Constellation> constellationList = new ArrayList<>();
        for (String str : constellationStrList) {
            String res = (String) redisTemplate.opsForValue().get(str);
            System.out.println(res);
            if (res != null) {
                Constellation constellation = JSON.parseObject(res, Constellation.class);
                constellationList.add(constellation);
            }
        }
        System.out.println(constellationList.toString());
    }

    @Test
    public void Test() throws UnsupportedEncodingException {
        String urlStr = URLEncoder.encode("天蝎座", "UTF-8");
        System.out.println(urlStr);
    }

    @Test
    public void Test01() {
        String pass = DigestUtils.md5DigestAsHex("password".getBytes());
        System.out.println(pass);
    }


}
