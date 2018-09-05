package com.example.demo;

import org.apache.logging.log4j.LogManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

@SpringBootApplication
public class DemoApplication {
    public Logger logger = LoggerFactory.getLogger(getClass());
    public org.apache.logging.log4j.Logger logger1 = LogManager.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
