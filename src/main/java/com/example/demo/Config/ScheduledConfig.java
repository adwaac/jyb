package com.example.demo.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
public class ScheduledConfig {
    @Bean
    public TaskScheduler taskScheduler() {
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        // 设置线程池大小
        scheduler.setPoolSize(5);
        // 设置线程名称前缀
        scheduler.setThreadNamePrefix("scheduled-task-");
        // 设置线程池关闭时等待所有任务完成
        scheduler.setWaitForTasksToCompleteOnShutdown(true);
        // 设置等待时间（秒）
        scheduler.setAwaitTerminationSeconds(60);
        // 初始化线程池
        scheduler.initialize();
        return scheduler;
    }
}
