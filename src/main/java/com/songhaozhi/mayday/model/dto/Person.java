package com.songhaozhi.mayday.model.dto;

import java.io.Serializable;

public class Person implements Serializable {

    public String fullName;

    public String sex;

    public String orginId;

    public String account;
    public String mobile;
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getOrginId() {
        return orginId;
    }

    public void setOrginId(String orginId) {
        this.orginId = orginId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
