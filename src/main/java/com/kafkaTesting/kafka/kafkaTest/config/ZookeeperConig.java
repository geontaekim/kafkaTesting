package com.kafkaTesting.kafka.kafkaTest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kafkaTesting.kafka.kafkaTest.listener.MyEventListener;

@Configuration
public class ZookeeperConig {
	
    @Bean
    public MyEventListener myEventListener() {
        return new MyEventListener();
    }

    @Bean
    public LoggingListener loggingListener() {
        return new LoggingListener("trace");
    }
}
	
