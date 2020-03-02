package com.songhaozhi.mayday.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.util.HttpUtil;
import com.songhaozhi.mayday.web.controller.admin.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class SubscribeController extends BaseController {

    @Value("${subscribe.add}")
    private String add;

    @Value("${subscribe.del}")
    private String del;

    @Value("${subscribe.findAll}")
    private String findAll;

    @Value("${subscribe.find}")
    private String find;

    /**
     * 添加消息订阅
     * @return
     */
    @RequestMapping(value = "/addSubscribe")
    @ResponseBody
    public JSONObject addSubscribe(String access_token,String content){
        JSONObject result = new JSONObject();
        try{
            add = add+"?access_token="+access_token;
            String request = HttpUtil.post(add,content,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 删除消息订阅
     * @return
     */
    @RequestMapping(value = "/DelSubscribe")
    @ResponseBody
    public JSONObject DelSubscribe(String access_token,String content){
        JSONObject result = new JSONObject();
        try{
            del = del+"?access_token="+access_token;
            String request = HttpUtil.post(del,content,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 查询用户的订阅信息
     * @return
     */
    @RequestMapping(value = "/findAll")
    @ResponseBody
    public JSONObject findAll(String access_token,String id ,String limit,String page){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap();
        inParam.put("access_token",access_token);
        inParam.put("id",id);
        inParam.put("limit",limit);
        inParam.put("page",page);
        try{
            String request = HttpUtil.get(findAll,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 查询用户是否订阅指定文章
     * @return
     */
    @RequestMapping(value = "/find")
    @ResponseBody
    public JSONObject find(String access_token,String userId,String articleId){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap();
        inParam.put("access_token",access_token);
        inParam.put("userId",userId);
        inParam.put("articleId",articleId);
        try{
            String request = HttpUtil.get(find,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }
}
