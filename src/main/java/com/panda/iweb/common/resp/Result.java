package com.panda.iweb.common.resp;

import java.io.Serializable;
import java.util.HashMap;

import com.panda.iweb.common.enums.ErrorCode;

public class Result implements Serializable {

    private static final long serialVersionUID = 9029051009743493868L;

    private int               errcode;                                // 返回码
    private String            errmsg;                                 // 返回说明
    private long              serverTime;                             // 服务器时间
    private Object            result;                                 // 返回内容

    public Result(){
        this.serverTime = System.currentTimeMillis();
        this.result = new HashMap<String, Object>();
    }

    public Result(ErrorCode errorCode){
        super();
        this.errcode = errorCode.getValue();
        this.errmsg = errorCode.getMsg();
        this.result = new HashMap<String, Object>();
    }

    public Result(ErrorCode errorCode, Object result){
        this.errcode = errorCode.getValue();
        this.errmsg = errorCode.getMsg();
        this.serverTime = System.currentTimeMillis();
        if (result != null) {
            this.result = result;
        } else {
            this.result = new HashMap<String, Object>();
        }

    }

    public int getErrcode() {
        return errcode;
    }

    public void setErrcode(ErrorCode errcode) {
        this.errcode = errcode.getValue();
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(ErrorCode errcode) {
        this.errmsg = errcode.getMsg();
    }

    public long getServerTime() {
        return serverTime;
    }

    public void setServerTime(long serverTime) {
        this.serverTime = serverTime;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setError(ErrorCode errcode) {
        this.errcode = errcode.getValue();
        this.errmsg = errcode.getMsg();
    }
}
