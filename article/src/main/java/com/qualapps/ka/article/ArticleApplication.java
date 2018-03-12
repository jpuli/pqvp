package com.qualapps.ka.article;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.qualapps.ka.data",
		"com.qualapps.ka.article",
		"com.qualapps.ka.controller",
		"com.qualapps.ka.service"})
@SpringBootApplication
@EnableAutoConfiguration
public class ArticleApplication {
	private static final Logger log = LoggerFactory.getLogger(ArticleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ArticleApplication.class, args);
	}
}
