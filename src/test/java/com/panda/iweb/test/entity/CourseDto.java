package com.panda.iweb.test.entity;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by chenlj on 2016/8/9.
 */
public class CourseDto implements Serializable {
    private static final long serialVersionUID = -7229570149021352856L;
    private Integer id;
    private transient String name;
    private Date createTime;
    private transient List<String> strs;

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


    public List<String> getStrs() {
        return strs;
    }

    public void setStrs(List<String> strs) {
        this.strs = strs;
    }

    public static void main(String[] args) {
        CourseDto courseDto = new CourseDto();
        courseDto.setId(1);
        courseDto.setName("小明");
        courseDto.setCreateTime(new Date());
        courseDto.setStrs(Lists.newArrayList("1", "2"));
        System.out.println(JSON.toJSONString(courseDto));
    }
}


