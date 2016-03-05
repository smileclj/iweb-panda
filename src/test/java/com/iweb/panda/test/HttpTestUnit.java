package com.iweb.panda.test;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.panda.iweb.util.common.HttpUtil;

public class HttpTestUnit {

    @Test
    public void post() throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", URLEncoder.encode("笑明", "UTF-8"));
        String url = "http://localhost:8080/iweb-panda/user/post.htm";
        System.out.println(HttpUtil.post(url, params));
    }
    
    @Test
    public void getAndPost() throws UnsupportedEncodingException {
        Map<String, String> params = new HashMap<String, String>();
        params.put("name", URLEncoder.encode("笑明", "UTF-8"));
        String url = "http://localhost:8080/iweb-panda/user/getAndPost.htm";
        System.out.println(HttpUtil.post(url, params));
    }
}
