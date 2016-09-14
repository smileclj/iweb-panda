package com.panda.iweb.test.test;

import com.alibaba.fastjson.JSON;
import com.panda.iweb.entity.ABRequest;
import com.panda.iweb.util.common.HttpUtil;
import com.panda.iweb.util.common.NetUtil;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class HttpTestUnit {

    @Test
    public void getUrlField() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("a", "1");
        params.put("b", "2");
        String url = "http://localhost:8080/user/getUrlField.htm";
        System.out.println(HttpUtil.get(url, params));
    }

    @Test
    public void getUrlObject() {
        Map<String, String> params = new HashMap<String, String>();
        params.put("a", "1");
        params.put("b", "2");
        String url = "http://localhost:8080/user/getUrlObject.htm";
        System.out.println(HttpUtil.get(url, params));
    }

    @Test
    public void postUrlField() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("a", "1");
        params.put("b", "2");
        String url = "http://localhost:8080/user/postUrlField.htm";
        System.out.println(NetUtil.post(url, NetUtil.join(params)));
    }

    @Test
    public void postUrlObject() {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("a", "1");
        params.put("b", "2");
        String url = "http://localhost:8080/user/postUrlObject.htm";
        System.out.println(NetUtil.post(url, NetUtil.join(params)));
    }

    @Test
    public void postJsonField() {
        ABRequest abRequest = new ABRequest();
        abRequest.setA("1");
        abRequest.setB("2");
        String url = "http://localhost:8080/user/postJsonField.htm";
        System.out.println(NetUtil.post(url, JSON.toJSONString(abRequest)));
    }

    @Test
    public void postJsonObject() {
        ABRequest abRequest = new ABRequest();
        abRequest.setA("1");
        abRequest.setB("2");
        String url = "http://localhost:8080/user/postJsonObject.htm";
        System.out.println(NetUtil.post(url, JSON.toJSONString(abRequest)));
    }

    @Test
    public void get_shop_audit_info() {
//        JSONObject jsonObject = new JSONObject();
//        String url = "http://localhost:8080/boss-api/shop/v1/get_shop_audit_info.action";
//        System.out.println(NetUtil.post(url, JSON.toJSONString(abRequest)));
    }

}
