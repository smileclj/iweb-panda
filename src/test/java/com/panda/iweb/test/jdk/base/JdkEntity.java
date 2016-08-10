package com.panda.iweb.test.jdk.base;

/**
 * Created by huixiangdou on 2016/8/5.
 */
public class JdkEntity {
    private Integer id;
    private String name;

    public JdkEntity() {
    }

    public JdkEntity(String name, Integer id) {
        this.name = name;
        this.id = id;
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
