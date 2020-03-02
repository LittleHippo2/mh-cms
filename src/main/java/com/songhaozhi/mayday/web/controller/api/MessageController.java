package com.songhaozhi.mayday.web.controller.api;

import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.util.HttpUtil;
import com.songhaozhi.mayday.web.controller.admin.BaseController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@RequestMapping(value = "/admin/message")
@Controller
public class MessageController extends BaseController {

    @Value("${message.personUrl}")
    private String PersonUrl;
    
    @Value("${message.departmentUrl}")
    private String departmentUrl;


    @GetMapping
    public String message() {
        return "admin/admin_message";
    }

    @PostMapping(value = "/sendPerson")
    public JSONObject sendOnce(String access_token, String userid, String content){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap<String,Object>();
        inParam.put("userid",userid);
        inParam.put("access_token",access_token);
        JSONObject jsonObject ;
        try{
            jsonObject = JSONObject.parseObject(content);
            inParam.put("content",jsonObject);
            PersonUrl = PersonUrl+userid;
            String request = HttpUtil.post(PersonUrl,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return result;
    }

    @PostMapping(value = "/sendDepartment")
    public JSONObject sendDepartment(String access_token,String content,String departmentid){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap<String,Object>();
        inParam.put("access_token",access_token);
        JSONObject jsonObject;
        try{
            jsonObject = JSONObject.parseObject(content);
            inParam.put("content",jsonObject);
            departmentUrl = departmentUrl+departmentid;
            String request = HttpUtil.post(departmentUrl,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return result;
    }
}
