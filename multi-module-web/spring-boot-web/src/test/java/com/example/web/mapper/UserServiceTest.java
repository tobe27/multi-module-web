package com.example.web.mapper;


import com.example.service.model.UserDO;
import com.example.service.service.UserDOService;
import com.example.service.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    UserDOService userDOService;

    @Test
    public void get() throws Exception {
        System.out.println(userService.list());
        System.out.println(userDOService.listUserDOs(new UserDO(),1, 10));
    }

}