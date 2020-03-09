package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.dto.Org;
import com.songhaozhi.mayday.model.dto.Relation;

import java.util.List;

public interface OrgService {

    List<Org> getOrgList(String fatherId);

    List<Org> getOrgList2(String fatherId, Integer startIndex, Integer endIndex);

    Integer getOrgList2Size(String fatherId);

    Integer insertOrgData(List<Org> list);

}
