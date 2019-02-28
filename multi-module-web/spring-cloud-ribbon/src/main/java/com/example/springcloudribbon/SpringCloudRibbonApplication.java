package com.example.springcloudribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient // 向服务中心注册，并且注册了一个叫restTemplate的bean
@SpringBootApplication
@EnableHystrix
@RestController
public class SpringCloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudRibbonApplication.class, args);
    }

    @Bean
    @LoadBalanced
        // 注册表明，这个restTemplate是需要做负载均衡的
    RestTemplate restTemplate() {
        return new RestTemplate();
    }


}

