package com.example.demo.Controller;

import com.example.demo.Entity.Response;
import com.example.demo.Entity.User;
import com.example.demo.Service.t1Service;
import com.example.demo.Util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.NoSuchAlgorithmException;

@Slf4j
@RestController
@RequestMapping(value = "/O1")
public class O1Controller {
    @Autowired
    User user;
    @Autowired
    t1Service t1Service;
    @Autowired
    Response response;

    @RequestMapping(value = "/log")
    public Response log(@RequestParam("username") String username, @RequestParam("password") String password) throws NoSuchAlgorithmException {
        System.out.println(username+"      "+password);
        user = t1Service.log(username,password);

        response.setUsername(user.getUsername());
        response.setStatus(Boolean.parseBoolean(user.getUsername()) ?"200":"500");
        String token = TokenUtil.sign(username);
        response.setToken(token);
        return response;
    }
}
