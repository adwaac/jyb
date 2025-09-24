package com.example.demo.Service;

import com.example.demo.Entity.Message;

public interface kafkaService {
    void sendMessage(String topic, Message message);
}
