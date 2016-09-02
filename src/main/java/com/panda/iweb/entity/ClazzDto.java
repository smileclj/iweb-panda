package com.panda.iweb.entity;

import java.io.Serializable;

/**
 * Created by huixiangdou on 2016/8/29.
 */
public class ClazzDto implements Serializable{
    private static final long serialVersionUID = 6585818109880433042L;
    private Integer id;
    private Course course;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
