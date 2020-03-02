package com.songhaozhi.mayday.service;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Backlog;

import java.util.List;

/**
 *待办处理
 */
public interface BacklogService {
    /**
     * 查询分页代办
     * @return List<Backlog>
     */
    public PageInfo<Backlog> selectPageBacklog(int page, int limit, Backlog backlog);

    public List<Backlog> selectBacklog(Backlog backlog);
    public int insertBacklog(Backlog backlog);
    public int updateBacklog(Backlog backlog);
    /**
     * 查询待办
     * @return List<Backlog>
     */
    public int selectBacklogCount(Integer state);


    public int deleteBacklog(Backlog backlog);
}
