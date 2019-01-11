package com.example.web.controller;

import com.example.common.validation.InsertGroup;
import com.example.web.entity.ResultBean;
import com.example.service.model.UserDO;
import com.example.service.service.UserDOService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by L.C.Y on 2018-11-22
 */
@RestController
@RequestMapping("/admin")
public class UserDOController {
    private final UserDOService userDOService;

    @Autowired
    public UserDOController(UserDOService userDOService) {
        this.userDOService = userDOService;
    }

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResultBean delete(@PathVariable Long id) throws Exception {
        userDOService.deleteByPrimaryKey(id);
        return new ResultBean().success();
    }

    /**
     * 新建
     * @param userDO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResultBean insert(@RequestBody @Validated(InsertGroup.class) UserDO userDO) throws Exception {
        userDOService.insertSelective(userDO);
        return new ResultBean().success();
    }

    /**
     * 编辑
     * @param userDO
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PUT)
    public ResultBean update(@RequestBody UserDO userDO) throws Exception {
        userDOService.updateByPrimaryKeySelective(userDO);
        return new ResultBean().success();
    }

    /**
     * 查询
     * @param id
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResultBean get(@PathVariable Long id) throws Exception {
        return new ResultBean().success(userDOService.getUserDO(id));
    }

    /**
     * 分页列表
     * @param pageNum 页码
     * @param pageSize 页行数
     * @return 分页列表
     * @throws Exception 参数异常
     */
    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public ResultBean list(UserDO userDO, Integer pageNum, Integer pageSize) throws Exception {
        PageInfo<UserDO> pageInfo = new PageInfo<>(userDOService.listUserDOs(userDO, pageNum, pageSize));
        return new ResultBean().success(pageInfo.getTotal(), pageInfo.getList());
    }

}
