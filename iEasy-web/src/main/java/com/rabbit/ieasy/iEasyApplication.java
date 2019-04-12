package com.rabbit.ieasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.rabbit.web
 * @description
 * @className iEasyApplication
 * @createDate 2019-03-18 2:39 PM
 */
@SpringBootApplication
@EnableScheduling
public class iEasyApplication {
    public static void main(String[] args) {
        SpringApplication.run(iEasyApplication.class, args);
    }

}
