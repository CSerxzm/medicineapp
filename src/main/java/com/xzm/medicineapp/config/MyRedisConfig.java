package com.xzm.medicineapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.net.UnknownHostException;

/**
 * @author xiangzhimin
 * @Description
 * @create 2021-01-19 18:46
 */

@Configuration
public class MyRedisConfig {
    //将对象使用json处理后，以便存入redis中。
    @Bean("myRedisTemplate")
    public RedisTemplate<Object, String> empRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, String> template = new RedisTemplate<Object, String>();
        template.setConnectionFactory(redisConnectionFactory);
        Jackson2JsonRedisSerializer<String> ser = new Jackson2JsonRedisSerializer<String>(String.class);
        template.setDefaultSerializer(ser);
        return template;
    }
}