package com.example.web.controller;

import com.example.web.entity.ResultBean;
import com.example.service.model.User;
import com.example.service.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
    public ResultBean findById(@PathVariable String id){
        return new ResultBean().success(userService.findById(id));
    }

    /**
     * 列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ResultBean list(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.list();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return new ResultBean().success(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 新建
     * @param user
     * @return
     */
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public ResultBean insertUser(@RequestBody User user){ //接收对象要使用@ModelAttribute注解
        userService.addUser(user);
        return new ResultBean().success();
    }

    /**
     * 编辑
     * @param user
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.PUT)
    public ResultBean updateUser(@RequestBody User user){
        userService.modifyName(user);
        return new ResultBean().success();
    }

    /**
     * 删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}",method = RequestMethod.DELETE)
    public ResultBean deleteById(@PathVariable String id){
        userService.delete(id);
        return new ResultBean().success();
    }

}
