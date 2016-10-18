package com.panda.iweb.test.entity;

import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;

import java.util.List;

/**
 * Created by huixiangdou on 2016/10/17.
 */
public class OvalEntity {
    private Integer id;
    private String name;
    private OvalEnum ovalEnum;
    @NotNull(when = "js:_this.ovalEnum.getCode() == 2")
    @Size(min = 1, when = "js:_this.ovalEnum.getCode() == 2")
    private List<Integer> list;

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

    public OvalEnum getOvalEnum() {
        return ovalEnum;
    }

    public void setOvalEnum(OvalEnum ovalEnum) {
        this.ovalEnum = ovalEnum;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
