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
public class TokenController extends BaseController {
    @Value("${token.url}")
    private String url;

    @Value("${token.ssoUrl}")
    private String ssoUrl;

    /**
     * getToken
     * @param client_id
     * @param client_secret
     * @return
     */
    @RequestMapping(value = "/getToken")
    @ResponseBody
    public JSONObject getToken(String client_id,String client_secret) {
        JSONObject result = new JSONObject();

        Map inParam = new HashMap<String,Object>();
        inParam.put("client_id",client_id);
        inParam.put("client_secret",client_secret);
        inParam.put("grant_type","client_credentials");//目前grant_type 仅支持 client_credentials
        try{
            String request = HttpUtil.post(url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return result;
    }


    @RequestMapping(value = "/getSso")
    @ResponseBody
    public JSONObject getSso(String username,String password,String loginMode,String service){
        JSONObject result = new JSONObject();
        Map inParam = new HashMap<String,Object>();
        inParam.put("username",username);
        inParam.put("password",password);
        inParam.put("loginMode",loginMode);
        inParam.put("service",service);
        try{
            String request = HttpUtil.post(ssoUrl,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }

}
