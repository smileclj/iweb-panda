package com.iweb.panda.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.iweb.panda.entity.TestObject;
import com.iweb.panda.util.JsonUtil;

public class TestCommon {

    @Test
    public void testJackson() {
        TestObject o = new TestObject();
        List<TestObject> list = new ArrayList<TestObject>();
        list.add(o);
        list.add(o);
        String s = JsonUtil.toJsonString(list);
        System.out.println(s);
        List<TestObject> l = JsonUtil.parseArray(s, TestObject.class);
        System.out.println(JSON.toJSONString(l));
    }

    @Test
    public void testFastJson() {
        TestObject o = new TestObject();
        System.out.println(JSON.toJSONString(o));
    }

}
