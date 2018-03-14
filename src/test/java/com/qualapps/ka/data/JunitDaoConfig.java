package com.qualapps.ka.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.qualapps.ka.data", "com.qualapps.ka.common"})
public class JunitDaoConfig {
    public static void main(String[] args) {
        SpringApplication.run(JunitDaoConfig.class, args);
    }
}
