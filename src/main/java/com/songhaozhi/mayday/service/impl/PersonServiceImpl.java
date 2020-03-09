package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.generator.PersonMapper;
import com.songhaozhi.mayday.model.dto.JsonUser;
import com.songhaozhi.mayday.model.dto.Person;
import com.songhaozhi.mayday.model.dto.Relation;
import com.songhaozhi.mayday.model.dto.User;
import com.songhaozhi.mayday.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonMapper personMapper;



    @Override
    public List<Person> getPersonList(String orgId, Integer startIndex, Integer endIndex) {
        return personMapper.getPersonList(orgId,startIndex, endIndex);
    }

    @Override
    public Integer getPersonsize(String orgId) {
        return personMapper.getPersonsize(orgId);
    }

    @Override
    public Integer insertUser(List<User> userList) {
        return personMapper.insertUser(userList);
    }

    @Override
    public Integer insertRelationData(List<Relation> list) {
        return personMapper.insertRelation(list);
    }

    @Override
    public Integer insertGxzccUserData(List<JsonUser> list) {
        return personMapper.insertGxzccUser(list);
    }


}