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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.apache.logging.log4j.util.Lazy.value;

@Service
public class t1ServiceImpl implements t1Service {
    @Autowired
    User user;
    @Autowired
    t1Mapper t1mapper;
    @Autowired
    RedisTemplate<String,Object> redisTemplate;

    private final Lock lock = new ReentrantLock();

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
        System.out.println(hexString.toString());
        return t1mapper.log(username, hexString.toString());
    }

    @Override
    public int test() {
        Long res = redisTemplate.opsForValue().increment("test",-1);
        if(res < 0){
            redisTemplate.opsForValue().increment("test",1);
            return 0;
        }
        return res.intValue();
    }
}
