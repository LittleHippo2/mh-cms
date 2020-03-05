package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.generator.DocData;
import com.songhaozhi.mayday.model.dto.DocDate;
import com.songhaozhi.mayday.service.RetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RetrievalServiceImpl implements RetrievalService {

    @Autowired
    private DocData docData;

    @Override
    public List<DocDate> getDocData(List like, Integer num) {
        return docData.getDocData(like, num);
    }

    @Override
    public Integer getDocDataCount(List like) {
        return docData.getDocDataCount(like);
    }
}
