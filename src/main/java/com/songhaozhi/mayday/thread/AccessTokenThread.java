package com.songhaozhi.mayday.thread;

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
@Order(value = 1)
public class AccessTokenThread implements ApplicationRunner{

    @Value("${access.appid}")
    private String appid;

    @Value("${access.secret}")
    private String secret;

    @Value("${access.url}")
    private String url;

    public static String accessToken;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        while(true) {
            Map inParam = new HashMap<String, Object>();
            inParam.put("client_id", appid);
            inParam.put("client_secret", secret);
            inParam.put("grant_type", "client_credentials");//目前grant_type 仅支持 client_credentials
            try {
                String request = HttpUtil.post(url, inParam, 3000, 3000);
                accessToken = JSONObject.parseObject(request).getString("access_token");
                Thread.sleep(JSONObject.parseObject(request).getInteger("expires_in"));
            } catch (Exception e) {
            }
        }
    }


}
