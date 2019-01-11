package com.example.service.dao;

import com.example.service.model.RolePermissionRelationDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RolePermissionRelationDOMapper {
    int deleteByRole(Long roleId);

    int insertSelective(RolePermissionRelationDO record);

    List<RolePermissionRelationDO> listRolePermissionRelationDOs(RolePermissionRelationDO record);
}