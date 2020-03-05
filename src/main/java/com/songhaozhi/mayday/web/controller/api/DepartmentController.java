package com.songhaozhi.mayday.web.controller.api;

import com.alibaba.fastjson.JSONArray;
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
public class DepartmentController extends BaseController {

    @Value("${sso.BaseUrl}")
    private String BaseUrl;

    /**
     * 获取部门列表
     * @param departmentid
     * @param isSublevel
     * @param isInvalid
     * @return
     */
    @RequestMapping(value = "/getDepartmentList")
    @ResponseBody
    public JSONArray getDepartmentList(String access_token, String departmentid, String isSublevel, String isInvalid) {
        JSONArray result = new JSONArray();
        String url = "/api/org/department/";
        Map inParam = new HashMap<String,Object>();
        try{
            url = url+departmentid+"/subdepartments?access_token="+access_token;
            if ("true".equals(isSublevel)){
                url = url +"&sublevel";
            }
            if ("true".equals(isInvalid)){
                url = url +"&invalid";
            }
            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            result = JSONArray.parseArray(request);
            log.info("result:"+request);
        }catch (Exception e ){
            log.error(e.getMessage());
            result.add("error");
        }
        return result;
    }

    /**
     * 获取部门详情
     * @param departmentid
     * @return
     */
    @RequestMapping(value = "/getDepartmentDetail")
    @ResponseBody
    public JSONObject getDepartmentDetail(String access_token, String departmentid) {
        JSONObject result = new JSONObject();
        String url = "/api/org/department/";
        Map inParam = new HashMap<String,Object>();

        try{
            url = url+departmentid+"?access_token="+access_token;
            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            result = JSONObject.parseObject(request);
            log.info("result:"+request);
        }catch (Exception e ){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 获取人员列表
     * @param departmentid
     * @param isSublevel
     * @param isInvalid
     * @return
     */
    @RequestMapping(value = "/getPersonList")
    @ResponseBody
    public JSONArray getPersonList(String access_token, String departmentid, String isSublevel, String isInvalid) {
        JSONArray result = new JSONArray();
        String url = "/api/org/department/";
        Map inParam = new HashMap<String,Object>();

        try{
            url = url+departmentid+"/userinfos?access_token="+access_token;
            if ("true".equals(isSublevel)){
                url = url +"&sublevel";
            }
            if ("true".equals(isInvalid)){
                url = url +"&invalid";
            }
            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            result = JSONArray.parseArray(request);
            log.info("result:"+request);
        }catch (Exception e ){
            log.error(e.getMessage());
            result.add("error");
        }
        return result;
    }

    /**
     * 获取人员详细信息（根据id）
     * @param id
     * @return
     */
    @RequestMapping(value = "/getPersonDetailById")
    @ResponseBody
    public JSONObject getPersonDetailById(String access_token, String id) {
        JSONObject result = new JSONObject();
        String url = "/api/org/userinfo/";
        Map inParam = new HashMap<String,Object>();

        try{
            url = url+id+"?access_token="+access_token;
            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            result = JSONObject.parseObject(request);
            log.info("result:"+request);
        }catch (Exception e ){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }

    /**
     * 获取人员详细信息（根据account）
     * @param account
     * @return
     */
    @RequestMapping(value = "/getPersonDetailByAccount")
    @ResponseBody
    public JSONObject getPersonDetailByAccount(String access_token, String account) {
        JSONObject result = new JSONObject();
        String url = "/api/org/userinfoext/";
        Map inParam = new HashMap<String,Object>();

        try{
            url = url+account+"?access_token="+access_token;
            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            log.info("result:"+request);
            result = JSONObject.parseObject(request);
        }catch (Exception e ){
            log.error(e.getMessage());
            result.put("error","error");
        }
        return result;
    }



}
