package com.smartgeek.component.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Starter
 *
 * @author Frank Zhang
 */
@SpringBootApplication
public class Application {
    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        try {
            SpringApplication.run(Application.class, args);
            log.info("Application run success");
        } catch (Exception e) {
            log.error("Application run fail errorMsg:{} ", e);
        }
    }
}
