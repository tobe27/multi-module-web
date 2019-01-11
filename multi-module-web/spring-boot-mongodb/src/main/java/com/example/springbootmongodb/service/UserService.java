package com.example.springbootmongodb.service;

import com.example.springbootmongodb.model.UserDO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserService {
    void saveUserDO(UserDO record) throws Exception;
    void removeUserDOByName(String name) throws Exception;
    void updateByName(UserDO record) throws Exception;
    List<UserDO> findUserDOsByName(String name) throws Exception;
}
