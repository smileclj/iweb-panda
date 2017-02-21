package com.panda.iweb.test.entity;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.panda.iweb.util.JsonUtil;

import java.beans.Transient;
import java.io.Serializable;

/**
 * Created by huixiangdou on 2017/1/11.
 */
public class Trsi implements Serializable {
    private static final long serialVersionUID = 409957201980390344L;
    private transient Integer id;
    private transient String name;
    @JsonIgnore
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static void main(String[] args) {
        Trsi trsi = new Trsi();
        trsi.setId(1);
        trsi.setName("a");
        trsi.setAddress("aaa");

        System.out.println(JsonUtil.toJsonString(trsi));
    }
}
