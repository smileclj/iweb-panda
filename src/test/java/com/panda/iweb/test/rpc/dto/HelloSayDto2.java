package com.panda.iweb.test.rpc.dto;

import java.io.Serializable;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class HelloSayDto2 implements Serializable{
    private static final long serialVersionUID = 4786067983424807475L;
    private int id;
    private String name;
    private String msg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
