package com.panda.iweb.test.entity;

/**
 * Created by huixiangdou on 2016/10/17.
 */
public enum OvalEnum {
    O1((byte)1, "a"), O2((byte)2, "b");

    private OvalEnum(byte code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private byte code;
    private String msg;

    public byte getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
