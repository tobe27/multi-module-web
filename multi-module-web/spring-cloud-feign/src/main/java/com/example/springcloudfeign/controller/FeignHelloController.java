package com.example.springcloudfeign.controller;

import com.example.springbootentity.entity.HelloEntity;
import com.example.springcloudfeign.service.FeignHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class FeignHelloController {

    private final FeignHelloService feignHelloService;

    @Autowired
    public FeignHelloController(FeignHelloService feignHelloService) {
        this.feignHelloService = feignHelloService;
    }

    @GetMapping("/hello")
    public String sayHello(String name) {
        return feignHelloService.sayHello(name);
    }

    @PostMapping("/hi")
    public HelloEntity getHelloEntity(@RequestBody HelloEntity helloEntity) {
        return feignHelloService.getHello(helloEntity);
    }
}
