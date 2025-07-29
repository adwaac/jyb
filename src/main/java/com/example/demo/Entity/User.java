package com.example.demo.Entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
@Component
public class User {
    private int userid;
    private String username;
    private String password;
    private String md;
}
