package com.example.demo.pro_con;

import com.example.demo.Entity.Message;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class kafkaCon {
    @KafkaListener(topics = "test-topic0",groupId = "my-group")
    public void listen(@Payload Message message) {
        System.out.println("test-topic0"+"  收到消息  "+message.toString());
    }
}
