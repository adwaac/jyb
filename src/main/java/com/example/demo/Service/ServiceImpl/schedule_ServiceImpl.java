package com.example.demo.Service.ServiceImpl;

import com.example.demo.Mapper.schedule_Mapper;
import com.example.demo.Service.schedule_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class schedule_ServiceImpl implements schedule_Service {
    @Autowired
    schedule_Mapper schedule_mapper;

    @Override
    public int save1(String b) {
        return schedule_mapper.insert1(b);
    }

    @Override
    public int save2(String b) {
        return schedule_mapper.insert2(b);
    }
}
