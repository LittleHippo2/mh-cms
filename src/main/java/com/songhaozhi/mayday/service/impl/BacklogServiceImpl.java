package com.songhaozhi.mayday.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.generator.ArticleMapper;
import com.songhaozhi.mayday.mapper.generator.BacklogMapper;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Backlog;
import com.songhaozhi.mayday.service.BacklogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class BacklogServiceImpl implements BacklogService {
    @Autowired
    private BacklogMapper backlogMapper;


    @Override
    public int insertBacklog(Backlog backlog)
    {
        return backlogMapper.insertBacklog(backlog);
    }

    @Override
    public int updateBacklog(Backlog backlog) {
        return backlogMapper.updateBacklog(backlog);
    }

    @Override
    public int selectBacklogCount(Integer state) {
        return backlogMapper.selectBacklogCount(state);
    }

    @Override
    public int deleteBacklog(Backlog backlog) {
        return backlogMapper.deleteBacklog(backlog);
    }

    @Override
    public PageInfo<Backlog> selectPageBacklog(int page, int limit,Backlog backlog) {

        PageHelper.startPage(page, limit);
        List<Backlog> lists = backlogMapper.selectBacklog(backlog);
        return new PageInfo<>(lists);


    }

    @Override
    public List<Backlog> selectBacklog(Backlog backlog) {
        return backlogMapper.selectBacklog(backlog);
    }

}
