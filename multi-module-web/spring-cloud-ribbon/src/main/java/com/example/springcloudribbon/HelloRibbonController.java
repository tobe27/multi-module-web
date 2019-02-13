package com.example.springcloudribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author CREATED BY L.C.Y on 2019-2-13
 */
@RestController
@RequestMapping
public class HelloRibbonController {

    private final HelloRibbonService helloRibbonService;

    @Autowired
    public HelloRibbonController(HelloRibbonService helloRibbonService) {
        this.helloRibbonService = helloRibbonService;
    }

    @RequestMapping("/")
    public String getHello() {
        return helloRibbonService.getHello();
    }
}
