package com.example.web.controller;

import com.example.service.model.PermissionDO;
import com.example.web.entity.ResultBean;
import com.example.service.service.PermissionDOService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Created by L.C.Y on 2018-11-26
 */
@RestController
@RequestMapping("/admin")
public class PermissionDOController {
    private final
    PermissionDOService permissionDOService;

    @Autowired
    public PermissionDOController(PermissionDOService permissionDOService) {
        this.permissionDOService = permissionDOService;
    }

    @RequestMapping(value = "/permission/{id}", method = RequestMethod.DELETE)
    public ResultBean delete(@PathVariable Long id) throws Exception {
        permissionDOService.deleteByPrimaryKey(id);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/permission", method = RequestMethod.POST)
    public ResultBean insert(@RequestBody PermissionDO permissionDO) throws Exception {
        permissionDOService.insertSelective(permissionDO);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/permission/{id}", method = RequestMethod.PUT)
    public ResultBean update(@RequestBody PermissionDO permissionDO) throws Exception {
        permissionDOService.updateByPrimaryKeySelective(permissionDO);
        return new ResultBean().success();
    }

    @RequestMapping(value = "/permission/{id}", method = RequestMethod.GET)
    public ResultBean get(@PathVariable Long id) throws Exception {
        return new ResultBean().success(permissionDOService.selectByPrimaryKey(id));
    }

    @RequestMapping(value = "/permission/list", method = RequestMethod.GET)
    public ResultBean list(PermissionDO permissionDO, Integer pageNum, Integer pageSize) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        PageInfo<PermissionDO> pageInfo = new PageInfo<>(permissionDOService.listPerms(permissionDO));
        return new ResultBean().success(pageInfo.getTotal(), pageInfo.getList());
    }
}
