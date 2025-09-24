package com.example.demo.Scheduled;

import com.example.demo.Service.schedule_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
//@PostConstruct 事务拦截器 拦截不了--->事务失效
public class scheduled {
//    @Autowired
//    schedule_Service schedule_service;
//
//    @Scheduled(fixedDelay=10000)
//    @Transactional(rollbackFor = Exception.class)
//    public void schedule() {
//        try{
//        System.out.println(schedule_service.save1("w"));
//        //System.out.println(schedule_service.save2("e"));
//        }
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
