package com.panda.iweb.test.rpc.dto;

import java.io.Serializable;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class HelloSayDto implements Serializable{
    private static final long serialVersionUID = -6901185209502826510L;
    private int id;
    private String name;
    private String msg;
//    private String address;

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

//    public String getAddress() {
//        return address;
//    }
//
//    public void setAddress(String address) {
//        this.address = address;
//    }
}
