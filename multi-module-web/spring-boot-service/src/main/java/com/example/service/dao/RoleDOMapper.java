package com.example.service.dao;

import com.example.service.model.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RoleDOMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(RoleDO record);

    RoleDO selectByPrimaryKey(Long id);

    List<RoleDO> listRoles(RoleDO record);

    int updateByPrimaryKeySelective(RoleDO record);
}