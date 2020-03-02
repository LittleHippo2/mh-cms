package com.songhaozhi.mayday.model.dto;

import java.io.Serializable;

public class ResponData implements Serializable{

    public ResponData(Object data) {
        this.data = data;
    }

    public Object data;

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
