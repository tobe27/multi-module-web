package com.example.springcloudribbon;

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

    public String getHello() {
        return restTemplate.getForObject("http://SERVICE-HELLO/", String.class);
    }

}
