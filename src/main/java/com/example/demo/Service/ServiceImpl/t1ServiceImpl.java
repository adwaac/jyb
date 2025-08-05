package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.User;
import com.example.demo.Mapper.t1Mapper;
import com.example.demo.Service.t1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import static org.apache.logging.log4j.util.Lazy.value;

@Service
public class t1ServiceImpl implements t1Service {
    //@Autowired 直接注入不能显式依赖关系
    private final User user;
    private final t1Mapper t1mapper;
    private final RedisTemplate<String,Object> redisTemplate;
    @Autowired
    public t1ServiceImpl(User user,t1Mapper t1mapper,RedisTemplate<String,Object> redisTemplate) {
        this.user = user;
        this.t1mapper = t1mapper;
        this.redisTemplate = redisTemplate;
    }



    @Override
    public boolean reg(User userEntity) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");

        String up = userEntity.getUsername()+userEntity.getPassword();

        // 将原始字符串转换为字节数组并计算MD5哈希值
        byte[] hashBytes = md.digest(up.getBytes());
        System.out.println(Arrays.toString(hashBytes));

        // 将字节数组转换为十六进制字符串
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }

        user.setUsername(userEntity.getUsername());
        user.setMd(hexString.toString());


        System.out.println("原始字符串: " + up);
        System.out.println("MD5加密后: " + hexString + value(hexString));
        return t1mapper.insert(user) > 0;
    }

    @Override
    public User log(String username, String password) throws NoSuchAlgorithmException {

        MessageDigest md = MessageDigest.getInstance("MD5");
        String up = username+password;
        System.out.println(up);
        byte[] hashBytes = md.digest(up.getBytes());
        StringBuilder hexString = new StringBuilder();
        for (byte b : hashBytes) {
            String hex = String.format("%02x", b);
            hexString.append(hex);
        }
        System.out.println(hexString);
        return t1mapper.log(username, hexString.toString());
    }

    @Override
    public int test() {
        //redisTemplate.opsForValue().increment---原子操作
        Long res = redisTemplate.opsForValue().increment("test",-1);
        if (res != null && res.intValue() < 0) {
            redisTemplate.opsForValue().increment("test", 1);
            return 0;
        }
        if (res != null) {
            return res.intValue();
        }
        return 0;
    }
}
