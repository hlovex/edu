package com.hlovex.edu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by hlovex on 2021/2/12 11:17
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.hlovex"})
public class EduApplication {
    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }
}
