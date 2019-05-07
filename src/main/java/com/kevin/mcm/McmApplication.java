package com.kevin.mcm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(value = "com.kevin.mcm")
public class McmApplication {

    public static void main(String[] args) {
        SpringApplication.run(McmApplication.class, args);
    }

}
