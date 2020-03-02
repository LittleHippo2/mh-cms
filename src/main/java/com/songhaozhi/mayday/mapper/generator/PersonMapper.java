package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.dto.Person;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface PersonMapper {

   List<Person> getPersonList(@Param("orgId") String orgId,
                              @Param("startIndex") Integer startIndex,
                              @Param("endIndex") Integer endIndex);



}
