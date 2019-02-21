package com.example.one.config.Schedule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 定时器配置类
 */


    @Configuration
    @EnableScheduling
    public class ScheduleConfig implements SchedulingConfigurer{
        @Override
        public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
            taskRegistrar.setScheduler(taskExecutor());
        }

        @Bean(destroyMethod="shutdown")
        public ExecutorService taskExecutor() {
            return Executors.newScheduledThreadPool(20);
        }
    }

