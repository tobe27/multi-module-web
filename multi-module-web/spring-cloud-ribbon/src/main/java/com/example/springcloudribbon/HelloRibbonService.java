package com.example.springcloudribbon;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author CREATED BY L.C.Y on 2019-2-13
 */
@Service
public class HelloRibbonService {

    private final RestTemplate restTemplate;

    @Autowired
    public HelloRibbonService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "serviceFailure")
    public String getHello() {
        return restTemplate.getForObject("http://SERVICE-HELLO/", String.class);
    }

    public String serviceFailure() {
        return "SERVICE-HELLO is not available";
    }

}
