package com.qualapps.pqvp;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.qualapps.ka.data",
        "com.qualapps.ka.data",
        "com.qualapps.ka.controller",
        "com.qualapps.pqvp",
        "com.qualapps.ka.service"})
@SpringBootApplication
@EnableAutoConfiguration
public class PqvpApplication {
  private static final Logger log = LoggerFactory.getLogger(PqvpApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(PqvpApplication.class, args);
  }

  @Bean
  public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
    return args -> {

      System.out.println("Let's inspect the beans provided by Spring Boot:");

      String[] beanNames = ctx.getBeanDefinitionNames();
      Arrays.sort(beanNames);
      for (String beanName : beanNames) {
        System.out.println(beanName);
      }

    };
  }
}
