package com.qualapps.ka;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration

public class SwaggerConfig {                                    
    @Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.qualapps.ka.controller"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(getApiInfo());
    }
    
  private ApiInfo getApiInfo() {
        return new ApiInfo(
          "DAAS API", 
          "QualApps- PQVP API.", 
          "1.0", 
          "Terms of service", 
          new Contact("Daas", "http://daas.qualapps.com", "jpuli@qualapps.com"), 
          "Apache License", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
   }
}
