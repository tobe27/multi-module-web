package com.example.service.service;

import com.example.service.model.PermissionDO;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-26
 */
public interface PermissionDOService {
    boolean deleteByPrimaryKey(Long id) throws Exception;

    boolean insertSelective(PermissionDO record) throws Exception;

    PermissionDO selectByPrimaryKey(Long id) throws Exception;

    List<PermissionDO> listPerms(PermissionDO record) throws Exception;

    boolean updateByPrimaryKeySelective(PermissionDO record) throws Exception;
}
