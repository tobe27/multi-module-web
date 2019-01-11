package com.example.service.service;

import com.example.service.model.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDOServiceTest {

    @Autowired
    UserService userService;
    @Autowired
    UserDOService userDOService;

    @Test
    public void get() throws Exception {
        System.out.println(userDOService.getUserDO(14L));
    }

}