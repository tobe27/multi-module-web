package com.example.service.dao;

import com.example.service.model.UserDO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDOMapper {
    int deleteByPrimaryKey(Long id);

    int insertSelective(UserDO record);

    UserDO getUserDO(Long id);

    UserDO getUserDOByUsername(String username);

    List<UserDO> listUserDOs(UserDO record);

    List<String> listStringRoles(Long id);

    List<String> listStringPerms(Long id);

    int updateByPrimaryKeySelective(UserDO record);
}