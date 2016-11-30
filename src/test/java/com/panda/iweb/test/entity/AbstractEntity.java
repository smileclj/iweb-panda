package com.panda.iweb.test.entity;

import java.io.Serializable;

/**
 * Created by huixiangdou on 2016/11/21.
 */
public abstract class AbstractEntity implements Serializable{
    private static final long serialVersionUID = -1356924485114658386L;
    private Integer id;
    private String name;

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
}
