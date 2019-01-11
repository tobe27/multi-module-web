package com.example.springbootmongodb.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.springbootmongodb.model.UserDO;
import com.example.springbootmongodb.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    UserService userService;

    @Test
    public void findByEmail() {
        System.out.println(JSON.toJSONString(mongoTemplate.findAll(UserDO.class, "user"), true));
    }

    @Test
    public void findAll() throws Exception {
        System.out.println(JSON.toJSONString(JSON.parse(userService.findUserDOsByName("mongodb1").get(0).getEmail()), true));
    }

    @Test
    public void save() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setName("mgdb1").setPassword("654321").setEmail("233@qq.com").setPhone("12345699886");
        userService.saveUserDO(userDO);
    }

    @Test
    public void update() throws Exception {
        UserDO userDO = new UserDO();
        userDO.setName("mgdb1").setPassword("654321333").setEmail("233333@qq.com").setPhone("1234569983386");
        userService.updateByName(userDO);
    }

    @Test
    public void remove() throws Exception {
        userService.removeUserDOByName("mongodb2");
    }
}