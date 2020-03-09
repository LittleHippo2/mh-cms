package com.songhaozhi.mayday.thread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.util.HttpUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Order(2)
public class IncrementThread implements ApplicationRunner {

    @Value("${sso.BaseUrl}")
    private String BaseUrl;


    private  AccessTokenThread accessTokenThread = new AccessTokenThread();

    /**
     * 增量同步
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {

        JSONObject result = new JSONObject();
        String url = "/api/org/syncdepartments";
        Map inParam = new HashMap<String,Object>();

        url = url+"?access_token="+accessTokenThread.accessToken;
        url = url+"&starttime="+1;
        url = url+"&department="+"";
        String request = HttpUtil.get(BaseUrl+url,inParam,3000,3000);
        JSONArray user = JSONObject.parseObject(request).getJSONArray("user");


    }
}
