package com.example.service.service;

import com.example.service.model.UserDO;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-22
 */
public interface UserDOService {
    /**
     * 删除用户
     * @param id 用户编号
     * @return boolean
     * @throws Exception 数据库异常
     */
    boolean deleteByPrimaryKey(Long id) throws Exception;

    /**
     * 新建用户
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    boolean insertSelective(UserDO record) throws Exception;

    /**
     * 查询用户
     * @param id 用户编号
     * @return 用户
     * @throws Exception 数据库异常
     */
    UserDO getUserDO(Long id) throws Exception;

    /**
     * 根据用户名查询
     * @param username 用户名
     * @return 用户
     * @throws Exception 数据库异常
     */
    UserDO getUserDOByUsername(String username) throws Exception;

    /**
     * 查询列表
     * @param record 用户
     * @param pageNum 页码
     * @param pageSize 页行数
     * @return 用户列表
     * @throws Exception 数据库异常
     */
    List<UserDO> listUserDOs(UserDO record, Integer pageNum, Integer pageSize) throws Exception;

    /**
     * 查询用户的所有角色
     * @param id 用户编号
     * @return 角色列表
     * @throws Exception 数据库异常
     */
    List<String> listStringRoles(Long id) throws Exception;

    /**
     * 查询用户的所有权限
     * @param id 用户编号
     * @return 权限列表
     * @throws Exception 数据库异常
     */
    List<String> listStringPerms(Long id) throws Exception;

    /**
     * 编辑用户
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    boolean updateByPrimaryKeySelective(UserDO record) throws Exception;
}
