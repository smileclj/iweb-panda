package com.panda.iweb.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by chenlj on 2016/8/9.
 */
public class CourseDto implements Serializable{
    private static final long serialVersionUID = -7229570149021352856L;
    private Integer id;
    private String name;
    private Date createTime;

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
}
