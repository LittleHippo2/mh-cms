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
public class LogController extends BaseController {

    @Value("${log.add}")
    private String add;

    @Value("${log.get}")
    private String get;

    @Value("${log.info}")
    private String info;

    @Value("${log.getplatform}")
    private String getplatform;

    /**
     * 添加日志
     * @return
     */
    @RequestMapping(value = "/addlog")
    @ResponseBody
    public JSONObject addlog(String access_token,String content){
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
     * 根据用户名审计应用日志
     * @param useraccount
     * @return
     */
    @RequestMapping(value = "/getlogs")
    @ResponseBody
    public JSONObject getlogs(String access_token,String useraccount,String starttime,String endtime){
        JSONObject result = new JSONObject();
        get = get + useraccount+"/getlogs";
        Map inParam = new HashMap<String,Object>();
        inParam.put("access_token",access_token);
        inParam.put("starttime",starttime);
        inParam.put("endtime",endtime);
        try{
            String request = HttpUtil.get(get,inParam,3000,3000);
            result = JSONObject.parseObject(request);
            log.info("result:"+request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 根据应用标识审计应用日志
     * @param appid
     * @return
     */
    @RequestMapping(value = "/getloginfo")
    @ResponseBody
    public JSONObject getloginfo(String access_token,String appid,String starttime,String endtime){
        JSONObject result = new JSONObject();
        info = info+appid+"/getloginfo";
        Map inParam = new HashMap<String,Object>();
        inParam.put("access_token",access_token);
        inParam.put("starttime",starttime);
        inParam.put("endtime",endtime);
        try{
            String request = HttpUtil.get(info,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 根据应用标识审计平台日志
     * @param appid
     * @return
     */
    @RequestMapping(value = "/getplatformlogs")
    @ResponseBody
    public JSONObject getplatformlogs(String access_token,String appid){
        JSONObject result = new JSONObject();
        getplatform = getplatform+appid+"/getplatformlogs";
        Map inParam = new HashMap<String,Object>();
        inParam.put("access_token",access_token);
        inParam.put("starttime","1470154736000");
        inParam.put("endtime","1470154836000");
        inParam.put("limit","10");
        inParam.put("page","1");
        try{
            String request = HttpUtil.get(getplatform,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }


}
