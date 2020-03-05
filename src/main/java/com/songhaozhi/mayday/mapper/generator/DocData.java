package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.dto.DocDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocData {

    List<DocDate> getDocData(@Param(value = "like") List like, @Param(value ="num") Integer num);

    Integer getDocDataCount(@Param(value = "like") List like);
}
