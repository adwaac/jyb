package com.example.demo.Init;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class RedisInit {
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    @PostConstruct
    public void init(){
        redisTemplate.opsForValue().set("test",500);
        System.out.println((Integer) Objects.requireNonNull(redisTemplate.opsForValue().get("test"))-1);
    }
}
