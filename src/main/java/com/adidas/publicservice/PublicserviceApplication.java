package com.adidas.publicservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PublicserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PublicserviceApplication.class, args);
    }

}
