package com.iweb.panda.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.iweb.panda.entity.ClassA;
import com.iweb.panda.entity.ClassB;
import com.iweb.panda.entity.ClassC;
import com.iweb.panda.entity.RefClass;
import com.iweb.panda.entity.TestObject;
import com.iweb.panda.util.JsonUtil;
import com.iweb.panda.util.common.BeanUtil;

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

        System.out.println(JSON.toJSONString(null).equals("null"));
    }

    @Test
    public void testCollections() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(5);
        list.add(1);
        list.add(2);
        Collections.sort(list);
        System.out.println(JsonUtil.toJsonString(list));
    }

    @Test
    public void testBeanUtil() throws Exception {
        ClassA a = new ClassA();
        a.setC_boolean(true);
        a.setC_byte((byte) 3);
        a.setC_char('你');
        a.setC_date(new Date());
        a.setC_double(1.2);
        a.setC_float(1.2f);
        a.setC_int(2);
        a.setC_long(33);
        a.setC_shrot((short) 3);
        a.setC_string("啦啦");
        a.setRef(new RefClass(1, "refa"));

        ClassA copy_A = (ClassA) BeanUtils.cloneBean(a);
        // System.out.println(JsonUtil.toJsonString(copy_A));

        ClassB b = new ClassB();
        BeanUtils.copyProperties(b, a);
        // System.out.println(JsonUtil.toJsonString(b));

        ClassC c = new ClassC();
        BeanUtils.copyProperties(c, a);
        System.out.println(JsonUtil.toJsonString(c));

    }

    @Test
    public void testBeanUtil2() throws Exception {
        ClassA a = new ClassA();
        a.setC_boolean(true);
        a.setC_byte((byte) 3);
        a.setC_char('你');
        a.setC_date(new Date());
        a.setC_double(1.2);
        a.setC_float(1.2f);
        a.setC_int(2);
        a.setC_long(33);
        a.setC_shrot((short) 3);
        a.setC_string("啦啦");
        a.setRef(new RefClass(1, "refa"));

        ClassB b = new ClassB();
        b.setC_boolean(false);
        b.setC_byte((byte) 4);
        b.setC_char('海');
        b.setC_date(null);
        b.setC_double(2.4);
        
        BeanUtil.copyProperties(a, b);
        System.out.println(JsonUtil.toJsonString(a));
    }
}
