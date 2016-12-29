package com.panda.iweb.test.entity;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by huixiangdou on 2016/12/29.
 */
public class Line {

    private String _id;

    public String get_id() {
        return _id;
    }

    @JSONField(name = "_id")
    public void set_id(String _id) {
        this._id = _id;
    }
}
