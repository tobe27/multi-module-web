package com.example.springcloudfeign.service;

import com.example.springbootentity.entity.HelloEntity;
import com.example.springcloudfeign.service.impl.FeignHelloServiceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hello", fallback = FeignHelloServiceImpl.class)
public interface FeignHelloService {

    /**
     * RequestParam注解必须要加
     * @param name
     * @return
     */
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(@RequestParam("name") String name);

    /**
     * POST请求JSON实体类
     * @param entity
     * @return
     */
    @RequestMapping(value = "/hi", method = RequestMethod.POST)
    public HelloEntity getHello(@RequestBody HelloEntity entity);


}
