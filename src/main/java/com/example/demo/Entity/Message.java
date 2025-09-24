package com.example.demo.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String id;
    private String content;
    private LocalDateTime time;
}
