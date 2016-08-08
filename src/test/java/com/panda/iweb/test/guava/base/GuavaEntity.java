package com.panda.iweb.test.guava.base;

/**
 * Created by huixiangdou on 2016/8/5.
 */
public class GuavaEntity {
    private Integer id;
    private String name;

    public GuavaEntity() {
    }

    public GuavaEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

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
