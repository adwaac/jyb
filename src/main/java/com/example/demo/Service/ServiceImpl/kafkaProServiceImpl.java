package com.example.demo.Service.ServiceImpl;

import com.example.demo.Entity.Message;
import com.example.demo.Service.kafkaService;
import com.example.demo.pro_con.kafkaPro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class kafkaProServiceImpl implements kafkaService {
    @Autowired
    private kafkaPro kafkaPro;
    @Override
    public void sendMessage(String topic, Message message) {
        message.setTime(LocalDateTime.now());
        kafkaPro.sendMessage(topic, message);
    }
}
