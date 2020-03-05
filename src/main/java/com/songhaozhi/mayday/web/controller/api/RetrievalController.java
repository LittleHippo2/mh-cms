package com.songhaozhi.mayday.web.controller.api;


import com.alibaba.fastjson.JSONArray;
import com.songhaozhi.mayday.model.dto.DocDate;
import com.songhaozhi.mayday.model.dto.RetrievalData;
import com.songhaozhi.mayday.service.RetrievalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api/search")
public class RetrievalController {

    @Autowired
    private RetrievalService retrievalService;


    @RequestMapping("/doc")
    @ResponseBody
    public RetrievalData getDoc(String access_token, HttpServletRequest request){

        String keyWords = request.getParameter("keyWords");
        String num = request.getParameter("num");

        JSONArray key = JSONArray.parseArray(keyWords);

        List list = new ArrayList<>();
        for(Object jstr:key){
            list.add(jstr);
        }
        List<DocDate> docDateList = retrievalService.getDocData(list, Integer.parseInt(num));
        List<Object> objectList = new ArrayList<>();
        for(DocDate docDate : docDateList){
            objectList.add(docDate);
        }

        return new RetrievalData("success", retrievalService.getDocDataCount(list), objectList);
    }
}
