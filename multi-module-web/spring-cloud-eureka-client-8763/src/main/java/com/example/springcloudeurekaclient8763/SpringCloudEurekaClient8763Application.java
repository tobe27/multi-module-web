package com.example.springcloudeurekaclient8763;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RestController;

@EnableEurekaClient
@SpringBootApplication
@RestController
public class SpringCloudEurekaClient8763Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaClient8763Application.class, args);
    }
}

