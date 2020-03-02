package com.songhaozhi.mayday.web.controller.backlog;

import cn.hutool.core.date.DateUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.*;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.BacklogService;
import com.songhaozhi.mayday.service.LogService;
import com.songhaozhi.mayday.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取代办任务数量接口
 */
@Controller
public class BacklogController {
    protected final Logger log = LoggerFactory.getLogger(getClass());
    @Autowired
    protected LogService logService;
    @Autowired
    private BacklogService backlogService;


    @RequestMapping(value = "/todo")
    @ResponseBody
    public String todo(String token, HttpServletRequest request) {

        JSONObject resJson = new JSONObject();
        String client_ip = request.getRemoteAddr();

        if (token != null && (!"".equals(token)) && (client_ip != null && (!"".equals(client_ip)))) {
            Backlog backlog =  new Backlog();
            backlog.setState(0);
            List<Backlog> result = backlogService.selectBacklog(backlog);
            resJson.put("result","success");
            resJson.put("count",result.size()+"");
        } else {
            resJson.put("result","failed");
        }
        return resJson.toString();
    }

    @GetMapping(value = "/backlog")
    public String backlog(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
                          @RequestParam(value = "limit", defaultValue = "10") int limit,
                          @RequestParam(value = "state", defaultValue = "0") Integer state) {


        Backlog backlog = new Backlog();
        backlog.setState(state);
        PageInfo<Backlog> pageInfo = backlogService.selectPageBacklog(page, limit,backlog);


        model.addAttribute("info", pageInfo);
        // 待办条数
        model.addAttribute("published",
                backlogService.selectBacklogCount(0));
        // 已办条数
        model.addAttribute("draft",
                backlogService.selectBacklogCount(1));
        // 回收站条数

        model.addAttribute("state", state);
        return "admin/backlog";

    }
    @RequestMapping(value = "/backlog/read")
    public String read(@RequestParam(value = "backlogId") String backlogId, HttpServletRequest request) {


        try {
            Backlog backlog = new Backlog();
            backlog.setBacklogId(backlogId);
            backlog.setState(1);
            backlogService.updateBacklog(backlog);
            // 添加日志
            logService.save(new Log(LogConstant.REMOVE_AN_ARTICLE, LogConstant.SUCCESS,
                    ServletUtil.getClientIP(request), DateUtil.date()));
        } catch (Exception e) {
            log.error("已读任务失败" + e.getMessage());
        }
        return "redirect:/backlog?state=0";

    }
    @RequestMapping(value = "/backlog/remove")
    public String remove(@RequestParam(value = "backlogId") String backlogId, HttpServletRequest request) {


        try {
            Backlog backlog = new Backlog();
            backlog.setBacklogId(backlogId);
            backlogService.deleteBacklog(backlog);
            // 添加日志
            logService.save(new Log(LogConstant.REMOVE_AN_ARTICLE, LogConstant.SUCCESS,
                    ServletUtil.getClientIP(request), DateUtil.date()));
        } catch (Exception e) {
            log.error("删除任务失败" + e.getMessage());
        }
        return "redirect:/backlog?state=1";

    }
    @RequestMapping(value = "/backlog/count")
    @ResponseBody
    public int backlogCount( HttpServletRequest request) {

        JSONObject resJson = new JSONObject();
        Backlog backlog =  new Backlog();
        backlog.setState(0);
        List<Backlog> result = backlogService.selectBacklog(backlog);

        return result.size();
    }
}
