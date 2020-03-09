package com.songhaozhi.mayday.thread;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.songhaozhi.mayday.model.dto.User;
import com.songhaozhi.mayday.service.PersonService;
import com.songhaozhi.mayday.util.HttpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
@Order(1)
public class AccessTokenThread implements ApplicationRunner{

    @Value("${access.appid}")
    private String appid;

    @Value("${access.secret}")
    private String secret;

    @Value("${access.url}")
    private String url;

    @Value("${sso.BaseUrl}")
    private String BaseUrl;

    @Autowired
    private PersonService personService;
    public static String accessToken;

    public static long startTime;
    /**
     * 获取微服务token
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        Integer time = 86400000;
        while(true) {
            Map inParam = new HashMap<String, Object>();
            inParam.put("client_id", appid);
            inParam.put("client_secret", secret);
            inParam.put("grant_type", "client_credentials");//目前grant_type 仅支持 client_credentials
            try {
                String request = HttpUtil.post(url, inParam, 3000, 3000);
                accessToken = JSONObject.parseObject(request).getString("access_token");

                String url2 = "/api/org/syncdepartments";
                Map inParam2 = new HashMap<String,Object>();

                url2 = url2+"?access_token="+accessToken;
                if (startTime == 0){
                    url2 = url2+"&starttime="+1;
                }else{
                    url2 = url2+"&starttime="+startTime;
                }
                url2 = url2+"&department="+"";

                String request2 = HttpUtil.get(BaseUrl+url2,inParam2,3000,3000);
                JSONArray user = JSONObject.parseObject(request2).getJSONArray("user");

                List<User> userList = new ArrayList<>();
                for(int i = 0; i<user.size(); i++){
                    User user1 = new User();
                    user1.setUserid(((JSONObject) user.get(i)).getString("userid"));
                    user1.setFullname(((JSONObject) user.get(i)).getString("fullname"));
                    user1.setUserEmail(((JSONObject) user.get(i)).getString("userEmail"));
                    user1.setAccount(((JSONObject) user.get(i)).getString("account"));
                    user1.setPassword(((JSONObject) user.get(i)).getString("password"));
                    userList.add(user1);
                }
                personService.insertUser(userList);

                startTime = System.currentTimeMillis();

                time = JSONObject.parseObject(request).getInteger("expires_in");
                if (time*1000<= 86400000){
                    Thread.sleep(time*1000);
                }else{
                    Thread.sleep(86400000);
                }
                } catch (Exception e) {
                if (time*1000<= 86400000){
                    Thread.sleep(time*1000);
                }else{
                    Thread.sleep(86400000);
                }
            }

        }
    }
}
