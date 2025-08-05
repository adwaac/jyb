package com.example.demo.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.Entity.User;
import com.example.demo.Service.ServiceImpl.t1ServiceImpl;
import com.example.demo.Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@RestController
@RequestMapping("/t1")
public class t1controller {
    @Autowired
    User user;
    @Autowired
    t1ServiceImpl t1service;
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    TokenUtil tokenUtil;


    @RequestMapping("/reg")
    public boolean reg(@RequestBody User user) throws NoSuchAlgorithmException {

        return t1service.reg(user);
    }

    @RequestMapping("/log")
    public User b(@RequestParam String username,String password) throws NoSuchAlgorithmException {
        System.out.println("0");
        user = t1service.log(username,password);
        System.out.println("1");
        System.out.println(user.toString());
        return user;
    }

    @RequestMapping("/sel")
    public boolean sel(@RequestParam String userid){
        System.out.println(userid);
        System.out.println(redisTemplate.opsForValue().get(userid));
        return true;
    }

    @RequestMapping("/test")
    public void test(){
        System.out.println(t1service.test());
    }

    @RequestMapping(value = "/userLogin")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password) throws NoSuchAlgorithmException {
        User user = t1service.log(username,password);
        if (user != null) {
            String res = TokenUtil.sign(username, password);
            System.out.println(res);
            return res;
        }

        return "失败";

    }
}
