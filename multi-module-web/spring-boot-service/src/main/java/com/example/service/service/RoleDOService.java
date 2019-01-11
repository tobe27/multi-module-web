package com.example.service.service;

import com.example.service.model.RoleDO;

import java.util.List;

/**
 * @author Created by L.C.Y on 2018-11-26
 */
public interface RoleDOService {
    boolean deleteByPrimaryKey(Long id) throws Exception;

    boolean insertSelective(RoleDO record) throws Exception;

    RoleDO selectByPrimaryKey(Long id) throws Exception;

    List<RoleDO> listRoles(RoleDO record) throws Exception;

    boolean updateByPrimaryKeySelective(RoleDO record) throws Exception;

}
