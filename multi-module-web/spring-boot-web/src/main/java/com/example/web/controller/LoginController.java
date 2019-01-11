package com.example.web.controller;

import com.example.common.util.JWTUtil;
import com.example.common.validation.LoginGroup;
import com.example.web.entity.ResultBean;
import com.example.service.model.UserDO;
import com.example.service.service.UserDOService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Created by L.C.Y on 2018-11-28
 */

@RestController
@RequestMapping
public class LoginController {

    private final
    UserDOService userDOService;

    @Autowired
    public LoginController(UserDOService userDOService) {
        this.userDOService = userDOService;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultBean login(@RequestBody @Validated(LoginGroup.class) UserDO record) throws Exception {
        UserDO userDO =  userDOService.getUserDOByUsername(record.getUsername());
        if (userDO == null) {
            return new ResultBean().fail("用户名不存在！");
        }
        if (!record.getPassword().equals(userDO.getPassword())) {
            return new ResultBean().fail("用户名或密码不正确！");
        }
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", userDO.getId());
        String token = JWTUtil.create(payload);

        // shiro认证
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(token, token);
        subject.login(usernamePasswordToken);

        return new ResultBean().success(userDO).withMore("Authorization", token);
    }


}
