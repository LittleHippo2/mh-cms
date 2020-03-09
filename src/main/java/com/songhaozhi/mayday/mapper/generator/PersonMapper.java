package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.dto.JsonUser;
import com.songhaozhi.mayday.model.dto.Person;
import com.songhaozhi.mayday.model.dto.Relation;
import com.songhaozhi.mayday.model.dto.User;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PersonMapper {

   List<Person> getPersonList(@Param("orgId") String orgId,
                              @Param("startIndex") Integer startIndex,
                              @Param("endIndex") Integer endIndex);

   Integer getPersonsize(@Param("orgId") String orgId);


   //插入mayday_user表
   Integer insertUser(@Param("userList") List<User> userList);

   //插入GXZCC_SYS_ORGAN_USER_RELATION表
   Integer insertRelation(@Param(value = "list")List<Relation> list);

   //插入gxzcc_user表
   Integer insertGxzccUser(@Param(value="list")List<JsonUser> list);


}
