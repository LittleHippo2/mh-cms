package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.dto.JsonUser;
import com.songhaozhi.mayday.model.dto.Person;
import com.songhaozhi.mayday.model.dto.Relation;
import com.songhaozhi.mayday.model.dto.User;

import java.util.List;

public interface PersonService {

    List<Person> getPersonList(String orgId, Integer startIndex, Integer endIndex);

    Integer getPersonsize(String orgId);

    Integer insertUser(List<User> userList);

    Integer insertRelationData(List<Relation> list);

    Integer insertGxzccUserData(List<JsonUser> list);

    Integer deleteRelation(List<String> list);

    Integer deleteUser(List<String> list);

    Integer deleteGxzccUser(List<String> list);
}
