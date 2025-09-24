package com.example.demo.Aspect;

import com.example.demo.Config.SSHConfig;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Component
public class StartUp {
    private SSHConfig sshConnection;
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        sshConnection = new SSHConfig();
        try {
            sshConnection.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @PreDestroy
    public void onApplicationShutdown() {
        sshConnection.disconnect();
    }
}
