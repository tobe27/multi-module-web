package com.example.service.dao;

import com.example.service.model.UserRoleRelationDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRoleRelationDOMapper {
    int deleteByUser(Long userId);

    int insertSelective(UserRoleRelationDO record);

    List<UserRoleRelationDO> listUserRoleRelationDOs(UserRoleRelationDO record);

}