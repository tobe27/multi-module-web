package com.example.service.service.impl;

import com.example.service.dao.PermissionDOMapper;
import com.example.service.dao.RolePermissionRelationDOMapper;
import com.example.service.exception.ServiceException;
import com.example.service.model.PermissionDO;
import com.example.service.model.RolePermissionRelationDO;
import com.example.service.service.PermissionDOService;
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
public class PermissionDOServiceImpl implements PermissionDOService {
    private final
    PermissionDOMapper permissionDOMapper;
    private final
    RolePermissionRelationDOMapper rolePermissionRelationDOMapper;

    @Autowired
    public PermissionDOServiceImpl(PermissionDOMapper permissionDOMapper, RolePermissionRelationDOMapper rolePermissionRelationDOMapper) {
        this.permissionDOMapper = permissionDOMapper;
        this.rolePermissionRelationDOMapper = rolePermissionRelationDOMapper;
    }

    private static Logger logger = LoggerFactory.getLogger(PermissionDOServiceImpl.class);

    @Override
    @Transactional
    public boolean deleteByPrimaryKey(Long id) throws Exception {
        List<RolePermissionRelationDO> rolePermissionRelationDOList =
                rolePermissionRelationDOMapper.listRolePermissionRelationDOs(new RolePermissionRelationDO().setPermissionId(id));
        if (rolePermissionRelationDOList != null && rolePermissionRelationDOList.size() != 0) {
            throw  new ServiceException("权限使用中，不可删除！");
        }

        try {
            return permissionDOMapper.deleteByPrimaryKey(id) == 1;
        } catch (Exception e) {
            logger.info("删除权限异常:" + e.getMessage());
            throw new ServiceException("删除权限异常");
        }
    }

    @Override
    public boolean insertSelective(PermissionDO record) throws Exception {
        long now = System.currentTimeMillis();
        record.setCreatedAt(now);
        record.setUpdatedAt(now);
        try {
            return permissionDOMapper.insertSelective(record) == 1;
        } catch (Exception e) {
            logger.info("新建权限异常:" + e.getMessage());
            throw new ServiceException("新建权限异常");
        }
    }

    @Override
    public PermissionDO selectByPrimaryKey(Long id) throws Exception {
        try {
            return permissionDOMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            logger.info("查看权限异常:" + e.getMessage());
            throw new ServiceException("查看权限异常");
        }
    }

    @Override
    public List<PermissionDO> listPerms(PermissionDO record) throws Exception {
        try {
            return permissionDOMapper.listPerms(record);
        } catch (Exception e) {
            logger.info("列表权限异常:" + e.getMessage());
            throw new ServiceException("列表权限异常");
        }
    }

    @Override
    public boolean updateByPrimaryKeySelective(PermissionDO record) throws Exception {
        long now = System.currentTimeMillis();
        record.setUpdatedAt(now);
        try {
            return permissionDOMapper.updateByPrimaryKeySelective(record) == 1;
        } catch (Exception e) {
            logger.info("编辑权限异常:" + e.getMessage());
            throw new ServiceException("编辑权限异常");
        }
    }
}
