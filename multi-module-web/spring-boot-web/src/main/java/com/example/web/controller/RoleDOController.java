package com.example.web.controller;

import com.example.web.entity.ResultBean;
import com.example.service.model.RoleDO;
import com.example.service.service.RoleDOService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by L.C.Y on 2018-11-26
 */
@RestController
@RequestMapping("/admin")
public class RoleDOController {
    private final
    RoleDOService roleDOService;

    @Autowired
    public RoleDOController(RoleDOService roleDOService) {
        this.roleDOService = roleDOService;
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.DELETE)
    public ResultBean delete(@PathVariable Long id) throws Exception {
        roleDOService.deleteByPrimaryKey(id);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResultBean insert(@RequestBody RoleDO roleDO) throws Exception {
        roleDOService.insertSelective(roleDO);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.PUT)
    public ResultBean update(@RequestBody RoleDO roleDO) throws Exception {
        roleDOService.updateByPrimaryKeySelective(roleDO);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/role/{id}", method = RequestMethod.GET)
    public ResultBean get(@PathVariable Long id) throws Exception {
        return new ResultBean().success(roleDOService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/role/list", method = RequestMethod.GET)
    public ResultBean list(RoleDO roleDO, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<RoleDO> pageInfo = new PageInfo<>(roleDOService.listRoles(roleDO));
        return new ResultBean().success(pageInfo.getTotal(), pageInfo.getList());
    }
}
