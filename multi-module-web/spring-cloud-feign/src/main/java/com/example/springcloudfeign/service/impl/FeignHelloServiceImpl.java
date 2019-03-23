package com.example.springcloudfeign.service.impl;

import com.example.springbootentity.entity.HelloEntity;
import com.example.springcloudfeign.service.FeignHelloService;
import org.springframework.stereotype.Component;

/**
 * 开启hystrix断路器，实现fallback返回的内容
 */
@Component
public class FeignHelloServiceImpl implements FeignHelloService {
    /**
     * RequestParam注解必须要加
     *
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name) {
        return "Feign服务异常，开启Hystrix:" + name;
    }

    /**
     * POST请求JSON实体类
     *
     * @param entity
     * @return
     */
    @Override
    public HelloEntity getHello(HelloEntity entity) {
        return new HelloEntity().setName("Hystrix").setMessage("Feign服务异常，开启Hystrix");
    }
}
