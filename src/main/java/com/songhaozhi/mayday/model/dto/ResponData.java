package com.songhaozhi.mayday.model.dto;

import java.io.Serializable;

public class ResponData implements Serializable{

    public ResponData(Object data, Integer size) {
        this.data = data;
        this.size = size;
    }

    public Object data;

    public Integer size;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
}
