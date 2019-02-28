package com.example.springcloudeurekaclient8763.service;

import com.example.springbootentity.entity.HelloEntity;

/**
 * @author CREATED BY L.C.Y on 2019-2-28
 */
public interface HelloService {

    /**
     * 说Hello
     * @param name
     * @return
     */
    String sayHello(String name);

    /**
     * 获取Hello实体
     * @param entity
     * @return
     */
    HelloEntity getHelloContent(HelloEntity entity);
}
