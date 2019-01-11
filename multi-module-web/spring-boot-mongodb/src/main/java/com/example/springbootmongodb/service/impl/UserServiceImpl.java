package com.example.springbootmongodb.service.impl;

import com.example.springbootmongodb.dao.UserDOMapper;
import com.example.springbootmongodb.model.UserDO;
import com.example.springbootmongodb.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserDOMapper userDOMapper;

    @Autowired
    public UserServiceImpl(UserDOMapper userDOMapper) {
        this.userDOMapper = userDOMapper;
    }

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public void saveUserDO(UserDO record) throws Exception {
        userDOMapper.saveUserDO(record);
    }

    @Override
    public void removeUserDOByName(String name) throws Exception {
        userDOMapper.removeUserDOByName(name);
    }

    @Override
    public void updateByName(UserDO record) throws Exception {
        userDOMapper.updateByName(record);
    }

    @Override
    public List<UserDO> findUserDOsByName(String name) throws Exception {
        return userDOMapper.findUserDOsByName(name);
    }
}
