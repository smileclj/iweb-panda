package com.iweb.panda.test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.panda.iweb.util.common.NetUtil;

public class HttpTestUnit {

	@Test
	public void postCommon1() throws UnsupportedEncodingException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "1");
		params.put("name", "postCommon1");
		String url = "http://localhost:8080/iweb-panda/user/postCommon1.htm";
		System.out.println(NetUtil.post(url, NetUtil.join(params)));
	}

	@Test
	public void postCommon2() throws UnsupportedEncodingException {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "1");
		params.put("name", "postCommon2");
		String url = "http://localhost:8080/iweb-panda/user/postCommon2.htm";
		System.out.println(NetUtil.post(url, NetUtil.join(params)));
	}

}
