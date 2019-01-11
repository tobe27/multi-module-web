package com.example.service.service.impl;

import com.example.service.dao.RoleDOMapper;
import com.example.service.dao.RolePermissionRelationDOMapper;
import com.example.service.dao.UserRoleRelationDOMapper;
import com.example.service.exception.ServiceException;
import com.example.service.model.PermissionDO;
import com.example.service.model.RoleDO;
import com.example.service.model.RolePermissionRelationDO;
import com.example.service.model.UserRoleRelationDO;
import com.example.service.service.RoleDOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-26
 */
@Service
public class RoleDOServiceImpl implements RoleDOService {
    private final
    RoleDOMapper roleDOMapper;

    private final
    UserRoleRelationDOMapper userRoleRelationDOMapper;

    private final
    RolePermissionRelationDOMapper rolePermissionRelationDOMapper;

    @Autowired
    public RoleDOServiceImpl(RoleDOMapper roleDOMapper, UserRoleRelationDOMapper userRoleRelationDOMapper, RolePermissionRelationDOMapper rolePermissionRelationDOMapper) {
        this.roleDOMapper = roleDOMapper;
        this.userRoleRelationDOMapper = userRoleRelationDOMapper;
        this.rolePermissionRelationDOMapper = rolePermissionRelationDOMapper;
    }

    private static Logger logger = LoggerFactory.getLogger(RoleDOServiceImpl.class);

    @Override
    @Transactional
    public boolean deleteByPrimaryKey(Long id) throws Exception {
        List<UserRoleRelationDO> userRoleRelationDOList =
                userRoleRelationDOMapper.listUserRoleRelationDOs(new UserRoleRelationDO().setRoleId(id));
        if (userRoleRelationDOList != null && userRoleRelationDOList.size() != 0) {
            throw new ServiceException("角色使用中，不可删除！");
        }
        int count;
        try {
            count = roleDOMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            logger.info("删除角色异常:" + e.getMessage());
            throw new ServiceException("删除角色异常");
        }

        // 删除关联表
        try {
            rolePermissionRelationDOMapper.deleteByRole(id);
        } catch (Exception e) {
            logger.info("删除角色权限关联表异常:" + e.getMessage());
            throw new ServiceException("删除角色权限关联表异常");
        }

        return count == 1;
    }

    @Override
    @Transactional
    public boolean insertSelective(RoleDO record) throws Exception {
        long now = System.currentTimeMillis();
        record.setCreatedAt(now);
        record.setUpdatedAt(now);
        int count;
        try {
            count = roleDOMapper.insertSelective(record);
        } catch (Exception e) {
            logger.info("新建角色异常:" + e.getMessage());
            throw new ServiceException("新建角色异常");
        }

        // 角色权限关联
        insertRolePermRelation(record);

        return count == 1;
    }

    @Override
    public RoleDO selectByPrimaryKey(Long id) throws Exception {
        try {
            return roleDOMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.info("查询角色异常:" + e.getMessage());
            throw new ServiceException("查询角色异常");
        }
    }

    @Override
    public List<RoleDO> listRoles(RoleDO record) throws Exception {
        try {
            return roleDOMapper.listRoles(record);
        } catch (Exception e) {
            logger.info("列表角色异常:" + e.getMessage());
            throw new ServiceException("列表角色异常");
        }
    }

    @Override
    @Transactional
    public boolean updateByPrimaryKeySelective(RoleDO record) throws Exception {
        long now = System.currentTimeMillis();
        record.setUpdatedAt(now);
        int count;
        try {
            count = roleDOMapper.updateByPrimaryKeySelective(record);
        } catch (Exception e) {
            logger.info("编辑角色异常:" + e.getMessage());
            throw new ServiceException("编辑角色异常");
        }

        // 角色权限关联
        insertRolePermRelation(record);

        return count == 1;
    }

    /**
     * 插入角色权限关联表
     * 插入之前删除关联信息
     * @param record 角色
     * @return 插入的条数
     */
    private int insertRolePermRelation(RoleDO record) {
        // 删除之前的权限
        rolePermissionRelationDOMapper.deleteByRole(record.getId());

        List<PermissionDO> permissionDOList = record.getPerms();
        int count = 0;
        for (PermissionDO permissionDO : permissionDOList) {
            RolePermissionRelationDO rolePermissionRelationDO = new RolePermissionRelationDO()
                    .setRoleId(record.getId())
                    .setPermissionId(permissionDO.getId())
                    .setCreatedAt(System.currentTimeMillis())
                    .setUpdatedAt(System.currentTimeMillis());
            try {
                // 插入关联表
                rolePermissionRelationDOMapper.insertSelective(rolePermissionRelationDO);
            } catch (Exception e) {
                logger.info("插入角色权限关联表异常:" + e.getMessage());
                throw new ServiceException("插入角色权限关联表异常");
            }
        }

        return count;
    }
}
