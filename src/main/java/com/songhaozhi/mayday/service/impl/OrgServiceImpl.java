package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.generator.OrgMapper;
import com.songhaozhi.mayday.model.dto.Org;
import com.songhaozhi.mayday.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrgServiceImpl implements OrgService {

    @Autowired
    private OrgMapper orgMapper;


    @Override
    public List<Org> getOrgList(String fatherId) {
        return orgMapper.getOrgList(fatherId);
    }

    @Override
    public List<Org> getOrgList2(String fatherId, Integer startIndex, Integer endIndex) {
        return orgMapper.getOrgList2(fatherId, startIndex, endIndex);
    }

    @Override
    public Integer getOrgList2Size(String fatherId) {
        return orgMapper.getOrgList2Size(fatherId);
    }


}