package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.dto.DocDate;

import java.util.List;

public interface RetrievalService {

    List<DocDate> getDocData(List like, Integer num);

    Integer getDocDataCount(List like);

}
