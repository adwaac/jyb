package com.example.demo.Controller;

import com.example.demo.Entity.Message;
import com.example.demo.Service.kafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private kafkaService kafkaService;
    @Autowired
    private Message message;


    @RequestMapping("send")
    public void sendMessage(@RequestParam("topic") String topic, @RequestParam("content") String content, @RequestParam("id")  String id) {
        message.setId(id);
        message.setContent(content);
        kafkaService.sendMessage(topic, message);
    }
}
