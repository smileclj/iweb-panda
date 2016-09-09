package com.panda.iweb.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by huixiangdou on 2016/9/6.
 */
public class CourseNew implements Serializable {
    private static final long serialVersionUID = 1192281298670266745L;
    private Integer id;
    private String name;
    private Date createTime;
    private Integer limit_num;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLimit_num() {
        return limit_num;
    }

    public void setLimit_num(Integer limit_num) {
        this.limit_num = limit_num;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
