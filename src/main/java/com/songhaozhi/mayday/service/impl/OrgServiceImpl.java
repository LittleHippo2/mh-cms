package com.songhaozhi.mayday.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.mapper.generator.OrgMapper;
import com.songhaozhi.mayday.model.dto.Org;
import com.songhaozhi.mayday.model.dto.Relation;
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

    @Override
    public Integer insertOrgData(List<Org> list) {
        return orgMapper.insertOrgData(list);
    }

    @Override

    public String getOrgJsonTree() {

        JSONArray jsonA = new JSONArray();
        List<Org> depart = getRootDepart();
        for(Org org:depart){
            JSONObject jsonO = new JSONObject();
            jsonO.put("organId",org.getOrganId());
            jsonO.put("text",org.getOrganName());
            jsonO.put("fatherId",org.getFatherId());

            //查询所有父节点数据，可以减少末节点的查询
            List<String> pList = orgMapper.getAllDepartsFatherId();

            String nodes = getSubDepartsForJsonString(org.getOrganId(), pList);
            if(!"".equals(nodes)&&nodes!=null){
                jsonO.put("nodes",JSONArray.parseArray(nodes));
            }
            jsonA.add(jsonO);
        }

        return jsonA.toString();
    }
    /**
     * 获取根目录
     */
    public List<Org> getRootDepart() {
        List<Org> depart = null;
        try {
            depart =  orgMapper.getOrgList("-1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return depart;
    }
    public String getSubDepartsForJsonString(String fatherId, List<String> pList)
    {
        JSONArray jsonA = new JSONArray();

        List<Org> list = orgMapper.getOrgList(fatherId);

        if(null!=list&&list.size()>0)
        {

            for(Org org:list){
                JSONObject jsonO = new JSONObject();
                jsonO.put("organId",org.getOrganId());
                jsonO.put("text",org.getOrganName());
                jsonO.put("fatherId",org.getFatherId());

                if (pList.contains(org.getOrganId())) {
                    String nodes = getSubDepartsForJsonString(org.getOrganId(), pList);
                    if(!"".equals(nodes)&&nodes!=null){
                        jsonO.put("nodes",JSONArray.parseArray(nodes));
                    }
                }
                jsonA.add(jsonO);
            }
        }
        return jsonA.toString();
    }

    public Integer deleteOrg(List<String> list) {
        return orgMapper.deleteOrgData(list);
    }



}