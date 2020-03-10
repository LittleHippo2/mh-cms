package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.dto.Org;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrgMapper {

   List<Org> getOrgList(@Param("parentId") String parentId);


   List<Org> getOrgList2(@Param("parentId") String parentId,
                         @Param("startIndex") Integer startIndex,
                         @Param("endIndex") Integer endIndex);

   Integer getOrgList2Size(@Param("parentId") String parentId);


   Integer insertOrgData(@Param(value = "list") List<Org> list);

   List<String> getAllDepartsFatherId();

   Integer deleteOrgData(@Param("list")List<String> list);

}
