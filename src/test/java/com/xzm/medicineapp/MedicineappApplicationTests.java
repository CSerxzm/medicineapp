package com.xzm.medicineapp;

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
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MedicineappApplicationTests {

	@Autowired
	@Qualifier("myRedisTemplate")
	private RedisTemplate redisTemplate;

	@Test
	public void contextLoads() {
		redisTemplate.opsForValue().set("键", "这是一段汉字",10, TimeUnit.HOURS);
		System.out.println(redisTemplate.opsForValue().get("键"));
	}

	@Test
	public void Test() throws UnsupportedEncodingException {
		String urlStr = URLEncoder.encode("天蝎座", "UTF-8");
		System.out.println(urlStr);
	}

	@Test
	public void Test01(){
		String pass = DigestUtils.md5DigestAsHex("password".getBytes());
		System.out.println(pass);
	}


}
