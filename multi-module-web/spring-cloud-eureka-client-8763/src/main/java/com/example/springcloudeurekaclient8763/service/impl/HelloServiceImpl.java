package com.example.springcloudeurekaclient8763.service.impl;

import com.example.springcloudeurekaclient8763.model.HelloEntity;
import com.example.springcloudeurekaclient8763.service.HelloService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author CREATED BY L.C.Y on 2019-2-28
 */
@Service
public class HelloServiceImpl implements HelloService {
    @Value("${server.port}")
    String port;

    /**
     * 说Hello
     *
     * @param name
     * @return
     */
    @Override
    public String sayHello(String name) {
        return "对" + name + "说: 你好 from " + port;
    }

    /**
     * 获取Hello实体
     *
     * @param helloEntity
     * @return
     */
    @Override
    public HelloEntity getHelloContent(HelloEntity helloEntity) {
        return new HelloEntity().setMessage(helloEntity.getMessage()).setName("成功8763");
    }
}
