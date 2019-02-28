package com.example.springcloudribbon.service;

import com.alibaba.fastjson.JSON;
import com.example.springcloudribbon.model.HelloEntity;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

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
    public String sayHello(String name) {
        Map<String, Object> paramMap = new HashMap<>(16);
        paramMap.put("name", name);
        return restTemplate.getForObject("http://SERVICE-HELLO/hello?name={name}", String.class, paramMap);
    }

    public HelloEntity getHello(HelloEntity entity) {
        System.out.println(JSON.toJSONString(entity, true));
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Map<String, Object> params = new HashMap<>(16);
        params.put("message", entity.getMessage());
        HttpEntity httpEntity = new HttpEntity(params, headers);
        // 两种方式都可以，接口默认接收参数是JSON格式
        // restTemplate.postForObject("http://SERVICE-HELLO/hi", entity, HelloEntity.class);
        return restTemplate.postForObject("http://SERVICE-HELLO/hi", httpEntity, HelloEntity.class);
    }


    /**
     * 要与调用的方法参数保持一致
     * @param name
     * @return
     */
    public String serviceFailure(String name) {
        return "SERVICE-HELLO is not available" + name;
    }

}
