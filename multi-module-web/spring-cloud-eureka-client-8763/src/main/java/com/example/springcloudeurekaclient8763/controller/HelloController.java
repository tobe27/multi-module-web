package com.example.springcloudeurekaclient8763.controller;

import com.example.springbootentity.entity.HelloEntity;
import com.example.springcloudeurekaclient8763.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author CREATED BY L.C.Y on 2019-2-28
 */
@RestController
@RequestMapping
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping(value = "/hello")
    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

    @PostMapping(value = "/hi")
    public HelloEntity getHello(@RequestBody HelloEntity entity) {
        return helloService.getHelloContent(entity);
    }
}
