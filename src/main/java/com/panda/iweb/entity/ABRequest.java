package com.panda.iweb.entity;

import java.io.Serializable;

/**
 * Created by huixiangdou on 2016/9/14.
 */
public class ABRequest implements Serializable {
    private String a;
    private String b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }
}
