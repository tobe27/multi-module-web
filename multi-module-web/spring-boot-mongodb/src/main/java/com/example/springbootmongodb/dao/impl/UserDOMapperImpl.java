package com.example.springbootmongodb.dao.impl;

import com.example.springbootmongodb.dao.UserDOMapper;
import com.example.springbootmongodb.model.UserDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDOMapperImpl implements UserDOMapper {
    private final MongoTemplate mongoTemplate;

    @Autowired
    public UserDOMapperImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void saveUserDO(UserDO record) {
        mongoTemplate.save(record, "user");
    }

    @Override
    public void removeUserDOByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        mongoTemplate.remove(query, UserDO.class, "user");
    }

    @Override
    public void updateByName(UserDO record) {
        Query query = new Query(Criteria.where("name").is(record.getName()));
        Update update = new Update().set("email", record.getEmail());
        mongoTemplate.updateMulti(query, update, "user");

    }

    @Override
    public List<UserDO> findUserDOsByName(String name) {
        Query query = new Query(Criteria.where("name").is(name));
        return mongoTemplate.find(query, UserDO.class, "user");
    }
}
