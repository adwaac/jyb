package com.example.demo.Service;

import com.example.demo.Entity.User;

import java.security.NoSuchAlgorithmException;

public interface t1Service {
    boolean reg(User user) throws NoSuchAlgorithmException;
    User log(String username,String password) throws NoSuchAlgorithmException;
    int test();
}
