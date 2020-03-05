package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.dto.DocDate;
import com.songhaozhi.mayday.model.dto.EmaliDate;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DocData {

    List<DocDate> getDocData(@Param(value = "like") List like, @Param(value ="num") Integer num);

    Integer getDocDataCount(@Param(value = "like") List like);

    List<EmaliDate> getEmailData(@Param(value = "like") List like, @Param(value ="num") Integer num);

    Integer getEmailDataCount(@Param(value = "like") List like);

    List<String> getApplData(@Param(value = "like") List like, @Param(value ="num") Integer num);

    Integer getAppDataCount(@Param(value = "like") List like);


}
