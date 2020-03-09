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

    @Value("${sso.BaseUrl}")
    private String BaseUrl;

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

    /**
     * 7.增量同步
     * @param starttime
     * @param department
     * @return
     */
    @RequestMapping(value = "/IncrSyn")
    @ResponseBody
    public JSONObject IncrSyn(String access_token, String starttime, String department) {
        JSONObject result = new JSONObject();
        String url = "/api/org/syncdepartments";
        Map inParam = new HashMap<String,Object>();

        try{
            url = url+"?access_token="+access_token;
            url = url+"&starttime="+starttime;
            url = url+"&department="+department;
            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            result = JSONObject.parseObject(request);
        }catch (Exception e ){
            result.put("error","error");
        }
        return result;
    }

    /**
     * refresh token
     */
    @RequestMapping(value = "/refresh")
    @ResponseBody
    public JSONObject refresh(String access_token){
        JSONObject result = new JSONObject();
        String url = "/api/sso/refresh/";
        Map inParam = new HashMap<String,Object>();
        try{
            url = url+access_token;
            String request = HttpUtil.post(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }


    /**
     * get sso token info
     * @param access_token
     * @return
     */
    @RequestMapping(value = "/getSsoInfo")
    @ResponseBody
    public JSONObject getSsoInfo(String access_token){
        JSONObject result = new JSONObject();
        String  url = "/api/sso/user";
        Map inParam = new HashMap<String,Object>();
        inParam.put("access_token",access_token);
        try{
            String request = HttpUtil.post(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }

    /**
     * check token
     * @param access_token
     * @return
     */
    @RequestMapping(value = "/checkToken")
    @ResponseBody
    public JSONObject checkToken(String access_token){
        JSONObject result = new JSONObject();
        String url = "/api/sso/valtoken";

        Map inParam = new HashMap<String,Object>();

        try{
            url = url + "/"+access_token;
            String request = HttpUtil.post(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }

    /**
     * update password
     */
    @RequestMapping(value = "/token/updatePassword")
    @ResponseBody
    public JSONObject updatePassword(String userName,String oldPassword,String newPassword,String repassword){
        JSONObject result = new JSONObject();
        String url = "/api/sso/password";
        Map inParam = new HashMap<String,Object>();
        inParam.put("account",userName);
        inParam.put("oldpassword",oldPassword);
        inParam.put("newpassword",newPassword);
        inParam.put("repassword",repassword);
        try{
            String request = HttpUtil.post(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }

    /**
     * update oapassword 不校验密码复杂度
     */
    @RequestMapping(value = "/token/updateoaPassword")
    @ResponseBody
    public JSONObject updateoaPassword(String userName,String oldPassword,String newPassword,String repassword){
        JSONObject result = new JSONObject();
        String url = "/api/sso/oapassword";
        Map inParam = new HashMap<String,Object>();
        inParam.put("account",userName);
        inParam.put("oldpassword",oldPassword);
        inParam.put("newpassword",newPassword);
        inParam.put("repassword",repassword);
        try{
            String request = HttpUtil.post(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }

    /**
     * 注销登录
     * @param access_token
     * @return
     */
    @RequestMapping(value = "/logout")
    @ResponseBody
    public JSONObject logout(String access_token){
        JSONObject result = new JSONObject();
        String url = "/api/sso/logout";
        Map inParam = new HashMap<String,Object>();
        try{
            url = url + "/"+access_token;
            String request = HttpUtil.post(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e){
            log.error(e.getMessage());
            result.put("result","error");
        }
        return  result;
    }
}
