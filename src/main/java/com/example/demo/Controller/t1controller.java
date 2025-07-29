package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.ServiceImpl.t1ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/t1")
public class t1controller {
    @Autowired
    t1ServiceImpl t1service;
    RedisTemplate<String, Object> redisTemplate;


    @RequestMapping("/reg")
    public boolean reg(@RequestBody User user) throws NoSuchAlgorithmException {

        return t1service.reg(user);
    }

    @RequestMapping("/log")
    public int b(@RequestParam String username,String password) throws NoSuchAlgorithmException {

        return t1service.log(username,password);
    }

    @RequestMapping("/sel")
    public boolean sel(@RequestParam String userid){
        System.out.println(userid);
        System.out.println(redisTemplate.opsForValue().get(userid));
        return true;
    }
}
