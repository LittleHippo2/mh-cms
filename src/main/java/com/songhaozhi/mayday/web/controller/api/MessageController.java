package com.songhaozhi.mayday.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.util.HttpUtil;
import com.songhaozhi.mayday.web.controller.admin.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class MessageController extends BaseController {

    @Value("${message.personUrl}")
    private String PersonUrl;
    
    @Value("${message.departmentUrl}")
    private String departmentUrl;


//    @GetMapping
//    public String message() {
//        return "admin/admin_message";
//    }

    @RequestMapping(value = "/sendPerson")
    @ResponseBody
    public JSONObject sendOnce(String access_token, String userid, String content){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap<String,Object>();
        inParam.put("userid",userid);
        inParam.put("access_token",access_token);
        JSONObject jsonObject ;
        try{
            jsonObject = JSONObject.parseObject(content);
            inParam.put("content",jsonObject);
            String url = PersonUrl;
            url = url+userid;
            String request = HttpUtil.post(url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return result;
    }

    @RequestMapping(value = "/sendDepartment")
    @ResponseBody
    public JSONObject sendDepartment(String access_token,String content,String departmentid){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap<String,Object>();
        inParam.put("access_token",access_token);
        JSONObject jsonObject;
        try{
            jsonObject = JSONObject.parseObject(content);
            inParam.put("content",jsonObject);
            String url = departmentUrl;
            url = url+departmentid;
            String request = HttpUtil.post(url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return result;
    }
}
