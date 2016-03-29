package com.iweb.panda.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.base.CaseFormat;
import com.iweb.panda.entity.ClassA;
import com.iweb.panda.entity.ClassB;
import com.iweb.panda.entity.ClassC;
import com.iweb.panda.entity.RefClass;
import com.iweb.panda.entity.TestObject;
import com.panda.iweb.util.JsonUtil;
import com.panda.iweb.util.common.BeanUtil;

public class TestCommonUnit {

	private static final Logger logger = LoggerFactory.getLogger(TestCommonUnit.class);

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

		// ClassA copy_A = (ClassA) BeanUtils.cloneBean(a);
		// System.out.println(JsonUtil.toJsonString(copy_A));

		// ClassB b = new ClassB();
		// BeanUtil.copyProperties(b, a);
		// System.out.println(JsonUtil.toJsonString(b));

		ClassC c = new ClassC();
		long start = System.currentTimeMillis();
		BeanUtil.copyProperties(c, a);
		long end = System.currentTimeMillis();
		System.out.println(JsonUtil.toJsonString(c));
		logger.info("耗时:{}ms", end - start);
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

	@Test
	public void testDate() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d1 = sdf.parse("2016-01-06 15:12:19");
		Date d2 = sdf.parse("2016-01-06 15:12:20");
		System.out.println(d1.after(d2));
		System.out.println(d1.before(d2));
	}

	@Test
	public void testEncode() throws UnsupportedEncodingException {
		// System.out.println(URLEncoder.encode("你好","UTF-8"));
		// System.out.println(URLEncoder.encode("abc", "UTF-8"));
		String str = "{\"action_name\":\"%E6%B5%8B%E8%AF%95%E7%BA%A2%E5%8C%85\",\"etype\":\"CASH\",\"openid\":\"oyv8Qt02HMA5A_YfT8QRmsu2XJdI\",\"remark\":\"a\",\"send_name\":\"a\",\"sign\":\"37e639ee5f5fecd3049bde1a158e178d\",\"system\":\"300\",\"timestamp\":\"1453202996375\",\"total_amount\":\"100\",\"total_num\":\"1\",\"wishing\":\"a\"}";
		JSONObject jsonObject = JSON.parseObject(str);
		for (Map.Entry<String, Object> entry : jsonObject.entrySet()) {
			logger.info("key:{},value:{}", entry.getKey(), URLDecoder.decode((String) entry.getValue(), "UTF-8"));
		}
	}

	@Test
	public void testGuava() {
		System.out.println(CaseFormat.LOWER_UNDERSCORE.toString());
		System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test.data"));

	}

	@Test
	public void testMath() {
		System.out.println((int) (2 / 258 * 10000));
	}

	@Test
	public void fastjson() {
		String json = "{\"id\":1,\"name\":\"小明\"}";
		JSONObject jsonObject = JSON.parseObject(json);
		jsonObject.put("sex", "男");
		System.out.println(jsonObject.toJSONString());
	}

	@Test
	public void testSubList() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(JsonUtil.toJsonString(list.subList(0, 2)));
	}

	@Test
	public void testDate2() {
		Date now = new Date();
		System.out.println(now.after(now));
		System.out.println(now.before(now));
		System.out.println(now.equals(now));
		System.out.println(now.compareTo(now));
	}
}
