package com.example.springbootmongodb.dao;

import com.example.springbootmongodb.model.UserDO;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;

public interface UserDOMapper {
    void saveUserDO(UserDO record);
    void removeUserDOByName(String name);
    void updateByName(UserDO record);
    List<UserDO> findUserDOsByName(String name);
}
