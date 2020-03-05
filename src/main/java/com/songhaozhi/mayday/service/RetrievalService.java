package com.songhaozhi.mayday.service;

import com.songhaozhi.mayday.model.dto.DocDate;
import com.songhaozhi.mayday.model.dto.EmaliDate;

import java.util.List;

public interface RetrievalService {

    List<DocDate> getDocData(List like, Integer num);

    Integer getDocDataCount(List like);

    List<EmaliDate> getEmailData(List like, Integer num);

    Integer getEmailDataCount(List like);


    List<String> getAppData(List like, Integer num);

    Integer getAppDataCount(List like);

}
