package com.songhaozhi.mayday.util;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HttpUtil {

    public static String time = "";


    private static final int READ_TIMEOUT = 60000;

    private static final int CONNECT_TIMEOUT = 60000;

    /**
     * http get request
     */
    public static String get(String urlAddr, Map<String, Object> paramsMap, int connectTimeout, int readTimeout) throws Exception {

        long begin = System.currentTimeMillis();
        String line;
        String params = "";
        HttpURLConnection conn = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        StringBuffer result = new StringBuffer();
        try {
            if (connectTimeout < 1) {
                connectTimeout = CONNECT_TIMEOUT;
            }
            if (readTimeout < 1) {
                readTimeout = READ_TIMEOUT;
            }
            if (paramsMap != null && !paramsMap.isEmpty()) {
                StringBuffer str = new StringBuffer();
                Set set = paramsMap.keySet();
                Iterator iter = set.iterator();
                while (iter.hasNext()) {
                    String key = iter.next().toString();
                    if (paramsMap.get(key) == null) {
                        continue;
                    }
                    str.append(key).append("=").append(paramsMap.get(key)).append("&");
                }
                if (str.length() > 0) {
                    params = "?" + str.substring(0, str.length() - 1);
                }
            }
            URL url = new URL(urlAddr + params);
            conn = (HttpURLConnection) url.openConnection();
            // 设置读取超时时间
            conn.setReadTimeout(readTimeout);
            // 设置连接超时时间
            conn.setConnectTimeout(connectTimeout);
            conn.connect();
            inputStreamReader = new InputStreamReader(conn.getInputStream(), "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception e) {
                }
            }
        }
        long end = System.currentTimeMillis();
        time = (end-begin)+"ms";
        return result.toString();
    }

    /**
     * http post request
     */
    public static String post(String urlAddr, Map<String, Object> paramsMap, int connectTimeout, int readTimeout) throws Exception {
        long begin = System.currentTimeMillis();
        String line;
        String params = "";
        HttpURLConnection conn = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        StringBuffer result = new StringBuffer();
        try {
            if (connectTimeout < 1) {
                connectTimeout = CONNECT_TIMEOUT;
            }
            if (readTimeout < 1) {
                readTimeout = READ_TIMEOUT;
            }
            if (paramsMap != null && !paramsMap.isEmpty()) {
                StringBuffer str = new StringBuffer();
                Set set = paramsMap.keySet();
                Iterator iter = set.iterator();
                while (iter.hasNext()) {
                    String key = iter.next().toString();
                    if (paramsMap.get(key) == null) {
                        continue;
                    }
                    str.append(key).append("=").append(paramsMap.get(key)).append("&");
                }
                if (str.length() > 0) {
                    params = str.substring(0, str.length() - 1);
                }
            }

            params = new String(params.getBytes("utf-8"));
            System.out.println(params);
            URL url = new URL(urlAddr);
            conn = (HttpURLConnection) url.openConnection();
            // 设置读取超时时间
            conn.setReadTimeout(readTimeout);
            // 设置连接超时时间
            conn.setConnectTimeout(connectTimeout);
            // 设置是否向HttpURLConnection输出，因为这个是post请求，参数要放在http正文内，
            // 因此需要设为true, 默认情况下是false
            conn.setDoOutput(true);
            // 不使用缓存,默认情况下是true
            conn.setUseCaches(false);
            // 设定请求的方法为"POST",默认是GET
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type","application/x-www-form-urlencoded;charset=UTF-8");
            if (!params.isEmpty()) {
                // 此处getOutputStream会隐含的进行connect()
                outputStreamWriter = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                // 写入
                outputStreamWriter.write(params);
                // 刷新该流的缓冲
                outputStreamWriter.flush();
            }
            inputStreamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e) {
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception e) {
                }
            }
        }
        long end = System.currentTimeMillis();
        time = (end-begin)+"ms";
        return result.toString();
    }



    /**
     * http post request
     */
    public static String post(String urlAddr, String paramsStr, int connectTimeout, int readTimeout) throws Exception {

        long begin = System.currentTimeMillis();
        String line;
        HttpURLConnection conn = null;
        BufferedReader bufferedReader = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        StringBuffer result = new StringBuffer();

        try {
            if (connectTimeout < 1) {
                connectTimeout = CONNECT_TIMEOUT;
            }
            if (readTimeout < 1) {
                readTimeout = READ_TIMEOUT;
            }
            URL url = new URL(urlAddr);
            conn = (HttpURLConnection) url.openConnection();
            // 设置读取超时时间
            conn.setReadTimeout(readTimeout);
            conn.setRequestProperty("Content-Type","application/json");
            try {
                JSONObject jsonObject = JSONObject.parseObject(paramsStr);
                if (jsonObject.getString("client_ip") != null){
                    conn.setRequestProperty("client_ip",jsonObject.getString("client_ip"));
                    jsonObject.remove("client_ip");
                    paramsStr = jsonObject.toString();
                }
            }catch (Exception e){
            }
            // 设置连接超时时间
            conn.setConnectTimeout(connectTimeout);
            // 设置是否向HttpURLConnection输出，因为这个是post请求，参数要放在http正文内，
            // 因此需要设为true, 默认情况下是false
            conn.setDoOutput(true);
            // 不使用缓存,默认情况下是true
            conn.setUseCaches(false);
            // 设定请求的方法为"POST",默认是GET
            conn.setRequestMethod("POST");
            if (paramsStr != null && !paramsStr.isEmpty()) {
                // 此处getOutputStream会隐含的进行connect()
                outputStreamWriter = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
                // 写入
                outputStreamWriter.write(paramsStr);
                // 刷新该流的缓冲
                outputStreamWriter.flush();
            }
            inputStreamReader = new InputStreamReader(conn.getInputStream(), "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);
            while ((line = bufferedReader.readLine()) != null) {
                result.append(line);
            }
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e) {
                }
            }
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (Exception e) {
                }
            }
            if (outputStreamWriter != null) {
                try {
                    outputStreamWriter.close();
                } catch (Exception e) {
                }
            }
            if (conn != null) {
                try {
                    conn.disconnect();
                } catch (Exception e) {
                }
            }
        }
        long end = System.currentTimeMillis();
        time = (end-begin)+"ms";
        return result.toString();
    }

    public static void main(String[] args) throws MalformedURLException {
        String urlAddr = "http://172.16.5.200:10005/api/msg/message/user/a6c7a79f-543b-4043-9426-43d3cc8b340c";
        //String line;
        //String params = "content={\"appid\":\"legacycpk.csse.cms\",\"display\":{\"notification\":true,\"system\":true,\"msgbox\":true},\"type\":\"application\",\"title\":\"title\",\"content\":\"中文\"}";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));

        //HttpEntity<String> request1 = new HttpEntity<>(params);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("access_token","b428218f-dd57-43db-9442-1ccf822b7cf9");
        map.add("content", "{\"appid\":\"legacycpk.csse.cms\",\"display\":{\"notification\":true,\"system\":true,\"msgbox\":true},\"type\":\"application\",\"title\":\"title\",\"content\":\"中文\"}");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( urlAddr, request , String.class );
        System.out.println(response.getBody());


    }
    public static String postMsg(String urlAddr, Map<String, Object> paramsMap, int connectTimeout, int readTimeout) throws Exception {
        long begin = System.currentTimeMillis();

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.valueOf("application/x-www-form-urlencoded;charset=UTF-8"));

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("access_token", (String) paramsMap.get("access_token"));
        map.add("content", (String) paramsMap.get("content"));

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( urlAddr, request , String.class );
        System.out.println(response.getBody());

        return response.getBody();
    }

}