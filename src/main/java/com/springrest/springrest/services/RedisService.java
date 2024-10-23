package com.springrest.springrest.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;


@Service
public class RedisService {

    @Autowired
    private StringRedisTemplate redisTemplate ;

    public void storeNameInRedis(String name) {
        // Store the value in Redis with the key 'name'
        redisTemplate.opsForValue().set("name", name);
    }
}
