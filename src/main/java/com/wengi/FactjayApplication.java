package com.wengi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@SpringBootApplication
@Import(value = {MongoConfiguration.class})
public class FactjayApplication {

    public static void main(String[] args) {
        SpringApplication.run(FactjayApplication.class, args);
    }
}
