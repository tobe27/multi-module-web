package com.example.springcloudribbon.controller;

import com.example.springbootentity.entity.HelloEntity;
import com.example.springcloudribbon.service.HelloRibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author CREATED BY L.C.Y on 2019-2-13
 */
@RestController
@RequestMapping
public class HelloRibbonController {

    private final HelloRibbonService helloRibbonService;
    List arrayList = new ArrayList();
    List linkedList = new LinkedList();
    Map hashMap = new HashMap();
    Map concurrentHashMap = new ConcurrentHashMap();

    @Autowired
    public HelloRibbonController(HelloRibbonService helloRibbonService) {
        this.helloRibbonService = helloRibbonService;
    }

    @GetMapping("/hello")
    public String getHello(String name) {
        return helloRibbonService.sayHello(name);
    }

    @PostMapping("/hi")
    public HelloEntity getHelloEntity(@RequestBody Map map) {
        return helloRibbonService.getHello(new HelloEntity().setMessage(map.get("message").toString()));
    }
}
