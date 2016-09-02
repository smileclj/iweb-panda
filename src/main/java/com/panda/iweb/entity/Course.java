package com.panda.iweb.entity;

import java.util.Date;

public class Course {
    private Integer id;

    private String name;

    private Date createTime;

    private Integer limit_num;

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
        this.name = name == null ? null : name.trim();
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
}