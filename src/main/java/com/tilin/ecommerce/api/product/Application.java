package com.tilin.ecommerce.api.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.setProperty("date.time.now",(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHH"))));
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/ecommerce-api-product/v1/list-product").allowedOrigins("http://localhost:4200");
            }
        };
    }

}
