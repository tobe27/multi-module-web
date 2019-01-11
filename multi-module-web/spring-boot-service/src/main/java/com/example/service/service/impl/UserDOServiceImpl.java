package com.example.service.service.impl;

import com.example.service.dao.UserDOMapper;
import com.example.service.dao.UserRoleRelationDOMapper;
import com.example.service.exception.ServiceException;
import com.example.service.model.RoleDO;
import com.example.service.model.UserDO;
import com.example.service.model.UserRoleRelationDO;
import com.example.service.service.UserDOService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-22
 */
@Service
public class UserDOServiceImpl implements UserDOService {
    private final
    UserDOMapper userDOMapper;
    private final
    UserRoleRelationDOMapper userRoleRelationDOMapper;

    @Autowired
    public UserDOServiceImpl(UserDOMapper userDOMapper, UserRoleRelationDOMapper userRoleRelationDOMapper) {
        this.userDOMapper = userDOMapper;
        this.userRoleRelationDOMapper = userRoleRelationDOMapper;
    }

    private static Logger logger = LoggerFactory.getLogger(UserDOServiceImpl.class);

    /**
     * 删除用户
     *
     * @param id 用户编号
     * @return boolean
     * @throws Exception 数据库异常
     */
    @Override
    @Transactional
    public boolean deleteByPrimaryKey(Long id) throws Exception {
        int count;
        try {
            count = userDOMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            logger.info("删除用户异常：" + e.getMessage());
            throw new ServiceException("删除用户异常");
        }

        // 删除关联表
        try {
            userRoleRelationDOMapper.deleteByUser(id);
        } catch (Exception e) {
            logger.info("删除用户角色关联表异常：" + e.getMessage());
            throw new ServiceException("删除用户角色关联表异常");
        }

        return count == 1;
    }

    /**
     * 新建用户
     * 同时导入用户角色关联表
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    @Override
    @Transactional
    public boolean insertSelective(UserDO record) throws Exception {
        if (userDOMapper.getUserDOByUsername(record.getUsername()) != null) {
            throw new ServiceException("用户名已存在！");
        }
        // 创建时间
        long now = System.currentTimeMillis();
        record.setCreatedAt(now);
        record.setUpdatedAt(now);
        int count;
        try {
            // 插入数据库
            count = userDOMapper.insertSelective(record);
        } catch (Exception e) {
            logger.info("新建用户异常：" + e.getMessage());
            throw new ServiceException("新建用户异常");
        }

        // 关联用户角色
        insertUserRoleRelation(record);

        return count == 1;
    }

    /**
     * 查询用户
     *
     * @param id 用户编号
     * @return 用户
     * @throws Exception 数据库异常
     */
    @Override
    public UserDO getUserDO(Long id) throws Exception {
        try {
            return userDOMapper.getUserDO(id);
        } catch (Exception e) {
            logger.info("查询用户异常：" + e.getMessage());
            throw new ServiceException("查询用户异常");
        }
    }

    /**
     * 根据用户名查询
     *
     * @param username 用户名
     * @return 用户
     * @throws Exception 数据库异常
     */
    @Override
    public UserDO getUserDOByUsername(String username) throws Exception {
        try {
            return userDOMapper.getUserDOByUsername(username);
        } catch (Exception e) {
            logger.info("查询用户异常：" + e.getMessage());
            throw new ServiceException("查询用户异常");
        }
    }

    /**
     * 查询列表
     * @param record 用户
     * @param pageNum 页码
     * @param pageSize 页行数
     * @return 用户列表
     * @throws Exception 数据库异常
     */
    @Override
    public List<UserDO> listUserDOs(UserDO record, Integer pageNum, Integer pageSize) throws Exception {
        if (pageNum == null || pageSize == null) {
            throw new ServiceException("页码和页行数不能为空");
        }
        try {
            PageHelper.startPage(pageNum, pageSize);
            return userDOMapper.listUserDOs(record);
        } catch (Exception e) {
            logger.info("查询用户列表异常：" + e.getMessage());
            throw new ServiceException("查询用户列表异常");
        }
    }

    /**
     * 查询用户的所有角色
     *
     * @param id 用户编号
     * @return 角色列表
     * @throws Exception 数据库异常
     */
    @Override
    public List<String> listStringRoles(Long id) throws Exception {
        try {
            return userDOMapper.listStringRoles(id);
        } catch (Exception e) {
            logger.info("查询用户的所有角色异常：" + e.getMessage());
            throw new ServiceException("查询用户的所有角色异常");
        }
    }

    /**
     * 查询用户的所有权限
     *
     * @param id 用户编号
     * @return 权限列表
     * @throws Exception 数据库异常
     */
    @Override
    public List<String> listStringPerms(Long id) throws Exception {
        try {
            return userDOMapper.listStringPerms(id);
        } catch (Exception e) {
            logger.info("查询用户的所有权限异常：" + e.getMessage());
            throw new ServiceException("查询用户的所有权限异常");
        }
    }

    /**
     * 编辑用户
     *
     * @param record 用户
     * @return boolean
     * @throws Exception 数据库异常
     */
    @Override
    @Transactional
    public boolean updateByPrimaryKeySelective(UserDO record) throws Exception {
        // 修改时间
        long now = System.currentTimeMillis();
        record.setUpdatedAt(now);
        int count;
        try {
            count = userDOMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            logger.info("编辑用户异常：" + e.getMessage());
            if (userDOMapper.getUserDOByUsername(record.getUsername()) != null) {
                throw new ServiceException("用户名已存在！");
            }
            throw new ServiceException("编辑用户异常");
        }

        // 关联用户角色
        insertUserRoleRelation(record);

        return count == 1;
    }


    /**
     * 插入用户角色关联表
     * 插入之前删除之前的角色
     * @param record 用户
     * @return 插入的条数
     */
    private int insertUserRoleRelation(UserDO record) {
        // 插入之前-删除之前的角色
        userRoleRelationDOMapper.deleteByUser(record.getId());

        int count = 0;
        // 关联用户角色
        List<RoleDO> roleDOList = record.getRoles();
        for (RoleDO roleDO : roleDOList) {
            UserRoleRelationDO userRoleRelationDO = new UserRoleRelationDO()
                    .setRoleId(roleDO.getId())
                    .setUserId(record.getId())
                    .setCreatedAt(System.currentTimeMillis())
                    .setUpdatedAt(System.currentTimeMillis());
            try {
                // 插入关联表
                userRoleRelationDOMapper.insertSelective(userRoleRelationDO);
                count ++;
            } catch (Exception e) {
                logger.info("插入用户角色关联表异常：" + e.getMessage());
                throw new ServiceException("插入用户角色关联表异常");
            }
        }
        return count;
    }
}
