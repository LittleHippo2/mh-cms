package com.songhaozhi.mayday.mapper.generator;

import com.songhaozhi.mayday.model.domain.Backlog;

import java.util.List;

public interface BacklogMapper {
    /**
     * 查询待办
     * @return List<Backlog>
     */
    public List<Backlog> selectBacklog(Backlog backlog);

    /**
     * 新增待办
     * @return
     */
    public int insertBacklog(Backlog backlog);
    public int updateBacklog(Backlog backlog);
    public int selectBacklogCount(Integer state);

    public int deleteBacklog(Backlog backlog);
}
