package com.songhaozhi.mayday.web.controller.api;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.model.dto.JsonUser;
import com.songhaozhi.mayday.model.dto.Org;
import com.songhaozhi.mayday.model.dto.Relation;
import com.songhaozhi.mayday.model.dto.User;
import com.songhaozhi.mayday.service.OrgService;
import com.songhaozhi.mayday.service.PersonService;
import com.songhaozhi.mayday.thread.AccessTokenThread;
import com.songhaozhi.mayday.util.HttpUtil;
import com.songhaozhi.mayday.web.controller.admin.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

@Controller
public class TokenController extends BaseController {
    @Value("${token.url}")
    private String url;

    @Value("${token.ssoUrl}")
    private String ssoUrl;

    @Value("${sso.BaseUrl}")
    private String BaseUrl;

    @Autowired
    private OrgService orgService;

    @Autowired
    private PersonService personService;

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
    @Transactional
    public JSONObject IncrSyn(String access_token, String starttime, @RequestParam(name = "department", required = false) String department) {
        JSONObject result = new JSONObject();
        String url = "/api/org/syncdepartments";
        Map inParam = new HashMap<String,Object>();

        try{
            url = url+"?access_token="+access_token;
            url = url+"&starttime="+starttime;
            if(department == null || "".equals(department)){
                url = url+"&department=";
            }else{
                url = url+"&department="+department;
            }

            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
            result = JSONObject.parseObject(request);

            //同步组织机构信息
            JSONArray org = JSONObject.parseObject(request).getJSONArray("org");
            JSONArray user = JSONObject.parseObject(request).getJSONArray("user");
            List<Org> orgList = null;
            List<User> userList = null;
            List<Relation> relationList = null;
            List<JsonUser> jsonUserList = null;
            if(org.size() ==0){
                result.put("orgMessage", "没有可以同步的组织机构信息");
            }else{
                orgList = new ArrayList<>();
                for(int i= 0; i<org.size(); i++){
                    Org org1 = new Org();
                    org1.setOrganId(((JSONObject)org.get(i)).getString("organId"));
                    org1.setPath(((JSONObject)org.get(i)).getString("p"));
                    org1.setOrganName(((JSONObject)org.get(i)).getString("organName"));
                    org1.setOrgUuid(((JSONObject)org.get(i)).getString("orguuid"));
                    org1.setCode(((JSONObject)org.get(i)).getString("code"));
                    org1.setOrderId(((JSONObject)org.get(i)).getString("orderId"));
                    org1.setIsDelete(((JSONObject)org.get(i)).getString("isDelete"));
                    org1.setFatherId(((JSONObject)org.get(i)).getString("fatherId"));
                    org1.setDn(((JSONObject)org.get(i)).getString("dn"));
                    org1.setType(((JSONObject)org.get(i)).getString("type"));
                    org1.setTimesTamp(((JSONObject)org.get(i)).getString("timestamp"));
                    orgList.add(org1);
                }
                if(orgList.size() != 0){
                    //同步gxzcc——org表
                    orgService.insertOrgData(orgList);
                }
            }

            if(user.size() == 0){
                result.put("userMessage","没有可以同步的人员信息");
            }else{
                //同步人员信息
                userList = new ArrayList<>();
                relationList = new ArrayList<>();
                jsonUserList = new ArrayList<>();
                for(int i = 0; i<user.size(); i++){
                    JsonUser jsonUser = new JsonUser();
                    jsonUser.setUserid(((JSONObject) user.get(i)).getString("userid"));
                    jsonUser.setFullname(((JSONObject) user.get(i)).getString("fullname"));
                    jsonUser.setAccount(((JSONObject) user.get(i)).getString("account"));
                    jsonUser.setPassword(((JSONObject) user.get(i)).getString("password"));
                    jsonUser.setSex(((JSONObject) user.get(i)).getString("sex"));
                    jsonUser.setOrganId(((JSONObject) user.get(i)).getString("organId"));
                    jsonUser.setOrderId(((JSONObject) user.get(i)).getString("orderId"));
                    jsonUser.setDn(((JSONObject) user.get(i)).getString("dn"));
                    jsonUser.setIsDelete(((JSONObject) user.get(i)).getString("isDelete"));
                    jsonUser.setCa(((JSONObject) user.get(i)).getString("ca"));
                    jsonUser.setIsManager(((JSONObject) user.get(i)).getString("isManager"));
                    jsonUser.setTokenId(((JSONObject) user.get(i)).getString("tokenId"));
                    jsonUser.setSpId(((JSONObject) user.get(i)).getString("spId"));
                    jsonUser.setSn(((JSONObject) user.get(i)).getString("sn"));
                    jsonUser.setIp(((JSONObject) user.get(i)).getString("ip"));
                    jsonUser.setStartDate(new Date());
                    jsonUser.setUserUuid(((JSONObject) user.get(i)).getString("userUuid"));
                    jsonUser.setUserEmail(((JSONObject) user.get(i)).getString("userEmail"));
                    jsonUser.setSecLevel(((JSONObject) user.get(i)).getString("secLevel"));
                    jsonUser.setFailedLoginCount(((JSONObject) user.get(i)).getString("failedLoginCount"));
                    jsonUser.setEditPwdTime(((JSONObject) user.get(i)).getString("editPwdTime"));
                    jsonUser.setMobile(((JSONObject) user.get(i)).getString("mobile"));
                    jsonUser.setTimestamp(((JSONObject) user.get(i)).getString("timestamp"));
                    jsonUser.setType(((JSONObject) user.get(i)).getString("type"));
                    jsonUser.setEndDate(new Date());
                    jsonUserList.add(jsonUser);


                    User user1 = new User();
                    user1.setUserid(((JSONObject) user.get(i)).getString("userid"));
                    user1.setFullname(((JSONObject) user.get(i)).getString("fullname"));
                    user1.setUserEmail(((JSONObject) user.get(i)).getString("userEmail"));
                    user1.setAccount(((JSONObject) user.get(i)).getString("account"));
                    user1.setPassword(((JSONObject) user.get(i)).getString("password"));


                    JSONArray relationArray = ((JSONObject) user.get(i)).getJSONArray("relation");
                    Relation relation = JSON.toJavaObject((JSON) relationArray.get(0),Relation.class);


                    relationList.add(relation);
                    userList.add(user1);
                }

                if(userList.size() != 0){
                    //同步mayday_user 表
                    personService.insertUser(userList);
                }
                if(relationList.size() != 0){
                    //同步GXZCC_SYS_ORGAN_USER_RELATION 表信息
                    personService.insertRelationData(relationList);
                }
                if(jsonUserList.size() != 0){
                    //同步gxzcc_user 表
                    personService.insertGxzccUserData(jsonUserList);
                }

            }


        }catch (DuplicateKeyException e ){
            result.put("error","数据插入数据库时，存在和数据库相同的数据，请输入准确的时间和部门id，确保数据不重复");
            log.error("数据插入数据库时，存在和数据库相同的数据，请输入准确的时间和部门id，确保数据不重复");
        } catch (Exception e) {
            result.put("error", "请求获取同步组织机构接口数据时出现问题，请检查接口");
            log.error(e.toString());
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
