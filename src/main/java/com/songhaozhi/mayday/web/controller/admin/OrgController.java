package com.songhaozhi.mayday.web.controller.admin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.model.dto.ResponData;
import com.songhaozhi.mayday.service.OrgService;
import com.songhaozhi.mayday.thread.AccessTokenThread;
import com.songhaozhi.mayday.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/admin/org")
public class OrgController {

    @Autowired
    private OrgService orgService;

    @Value("${sso.BaseUrl}")
    private String BaseUrl;

    private  AccessTokenThread accessTokenThread = new AccessTokenThread();
    /**
     *
     * @param
     * @return 返回组织机构页面
     */
    @GetMapping
    public String page() {

//        Model model, @RequestParam(value = "page", defaultValue = "1") int page,
//        @RequestParam(value = "limit", defaultValue = "10") int limit,
//        @RequestParam(value = "departmentid") String departmentid,
//        @RequestParam(value = "isSublevel") String isSublevel,
//        @RequestParam(value = "isInvalid") String isInvalid

//        JSONArray result = new JSONArray();
//        String url = "/api/org/department/";
//        Map inParam = new HashMap<String,Object>();
//        String access_token = accessTokenThread.accessToken;
//        try{
//            url = url+departmentid+"/subdepartments?access_token="+access_token;
//            if ("true".equals(isSublevel)){
//                url = url +"&sublevel";
//            }
//            if ("true".equals(isInvalid)){
//                url = url +"&invalid";
//            }
//            String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
//            result = JSONArray.parseArray(request);
//
//            List departList = JSONObject.parseArray(result.toJSONString(), Depart.class);
//
//            int count;
//            if(departList != null && departList.size() > 0) {
//                count = departList.size();
//                int fromIndex = (limit-1) * page;
//                int toIndex = limit * page;
//                if (toIndex > count) {
//                    toIndex = count;
//                }
//                List<Depart> pageList = departList.subList(fromIndex, toIndex);
//                for (Depart p: pageList){
//                    p.setCount(count);
//                }
//                result = JSONArray.parseArray(JSON.toJSONString(pageList));
//            }
//        }catch (Exception e ){
//            result.add("error");
//        }
        return "admin/admin_org";
    }

    @RequestMapping("/getOrgList")
    @ResponseBody
    public ResponData getOrlList(
                                 @RequestParam(name ="fatherId", required = false)String fatherId){

        return new ResponData(orgService.getOrgList(fatherId));
    }

    @RequestMapping("/getOrgList2")
    @ResponseBody
    public ResponData getOrlList2(@RequestParam(value = "page", defaultValue = "1") int page,
                                 @RequestParam(value = "limit", defaultValue = "10") int limit,
                                 @RequestParam(name ="fatherId", required = false)String fatherId){
        //开始角标
        int fromIndex = (limit-1) * page;
        //结束角标
        int toIndex = limit * page;

        return new ResponData(orgService.getOrgList2(fatherId, fromIndex, toIndex));
    }


}
