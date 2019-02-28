package com.example.springcloudeurekaclient8762;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class SpringCloudEurekaClient8762Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClient8762Application.class, args);
    }

}

