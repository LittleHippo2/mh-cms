package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.dto.Person;
import com.songhaozhi.mayday.model.dto.User;

import java.util.List;

public interface PersonService {

    List<Person> getPersonList(String orgId, Integer startIndex, Integer endIndex);

    Integer getPersonsize(String orgId);

    Integer insertUser(List<User> userList);
}
