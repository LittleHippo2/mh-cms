package com.songhaozhi.mayday.model.dto;

import java.util.List;

public class RetrievalData {
    public RetrievalData(String result, Integer total, List<Object> data) {
        this.result = result;
        this.total = total;
        this.data = data;
    }

    private String result;

    private Integer total;

    private List<Object> data;


    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }
}
