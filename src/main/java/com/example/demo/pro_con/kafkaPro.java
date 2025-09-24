package com.example.demo.pro_con;

import com.example.demo.Entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class kafkaPro {
    @Autowired
    private KafkaTemplate<String, Message> kafkaTemplate;
    public void sendMessage(String topic, Message message){
        System.out.println(message);
        kafkaTemplate.send(topic, message).whenComplete((res, e) -> {
            if (e != null) {
                System.out.println(e);
            }  else {
                System.out.println(res);
            }
        });
    }
}
