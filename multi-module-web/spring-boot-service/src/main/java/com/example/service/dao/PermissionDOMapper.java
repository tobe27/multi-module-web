package com.example.service.dao;

import com.example.service.model.PermissionDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface PermissionDOMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(PermissionDO record);

    PermissionDO selectByPrimaryKey(Long id);

    List<PermissionDO> listPerms(PermissionDO record);

    int updateByPrimaryKeySelective(PermissionDO record);

}