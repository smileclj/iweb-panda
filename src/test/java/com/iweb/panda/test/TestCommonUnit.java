package com.iweb.panda.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.type.TypeReference;
import com.google.common.base.CaseFormat;
import com.iweb.panda.entity.ClassA;
import com.iweb.panda.entity.ClassB;
import com.iweb.panda.entity.ClassC;
import com.iweb.panda.entity.RefClass;
import com.iweb.panda.entity.Student;
import com.iweb.panda.entity.TestObject;
import com.panda.iweb.test.reflect.ReflectTest;
import com.panda.iweb.util.JsonUtil;
import com.panda.iweb.util.common.BeanUtil;
import com.panda.iweb.util.common.NetUtil;

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

	@Test
	public void hashcode() {
		System.out.println(new Integer(1).hashCode());
		System.out.println(new Double(1.1).hashCode());
		System.out.println("a".hashCode());
		System.out.println("a".hashCode());
		System.out.println(new Boolean(true).hashCode());
		System.out.println(new Boolean(false).hashCode());
	}

	@Test
	public void jdk1_7() {
		int a = 100_100;
		System.out.println(a);
	}

	@Test
	public void jdk1_8() {
		Object[] os = {};
		Object[] os2 = {};
		System.out.println(os.getClass().getComponentType());

		Object o = new Object();
		System.out.println(o.getClass().getComponentType());
		System.out.println(os);
	}

	@Test
	public void equals() {
		Boolean b1 = new Boolean(true);
		Boolean b2 = new Boolean(true);
		System.out.println(b1.equals(b2));
	}

	@Test
	public void arrayCopy() {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6 };
		int index = 1;
		int moveNum = a.length - index - 1;
		System.arraycopy(a, index + 1, a, index, moveNum);
		System.out.println(Arrays.toString(a));
	}

	@Test
	public void http() {
		String url = "http://www.panda.com:8081";
		System.out.println(NetUtil.get(url));
	}

	@Test
	public void https() {
		String url = "https://www.baidu.com";
		System.out.println(NetUtil.securePostByAuth(url, null));
	}

	@Test
	public void reflect() {
		try {
			Class<?> clazz = TestCommonUnit.class.getClassLoader().loadClass("com.panda.iweb.test.reflect.ReflectTest");
			Method method = clazz.getMethod("getName", new Class[] {});
			ReflectTest relectTest = new ReflectTest();
			relectTest.setAge(5);
			relectTest.setName("小红");
			Object o = (Object) relectTest;
			System.out.println(o instanceof ReflectTest);
			System.out.println(o.getClass());
			try {
				System.out.println(method.invoke(o, new Object[] {}));
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			}
		} catch (ClassNotFoundException e) {
		} catch (NoSuchMethodException e) {
		} catch (SecurityException e) {
		}
	}

	@Test
	public void collections() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(3);
		list.add(3);
		list.add(2);
		list.add(1);
		list.add(1);
		// IntegerCollections.max(list);
	}

	@Test
	public void longT() {
		System.out.println(Long.parseLong("01"));
	}

	@Test
	public void toS() {
		List<String> list = new ArrayList<String>();
		list.add("a");
		list.add("b");
		String r = list.toString().substring(1, list.toString().length() - 1);
		String[] ss = r.split(",");
		System.out.println(Arrays.toString(ss));
		System.out.println(r);

		String[] s = new String[] { "d", "f" };
		System.out.println(Arrays.toString(s));
	}

	@Test
	public void booleant() {
		System.out.println(Boolean.valueOf("1"));
		System.out.println(Boolean.valueOf("true"));
	}

	@Test
	public void map() {
		// Map<String, String> map = new IdentityHashMap<String, String>();
		// map.put(new String("1"), "a");
		// map.put(new String("1"), "b");
		// for (Map.Entry<String, String> entry : map.entrySet()) {
		// System.out.println(entry.getKey());
		// System.out.println(entry.getValue());
		// }

		Map<String, String> map = new HashMap<String, String>();
		map.put("1", "a");
		map.put("2", "b");

		Set<Map.Entry<String, String>> allSet = map.entrySet();
		Iterator<Map.Entry<String, String>> it = allSet.iterator();
		while (it.hasNext()) {
			Map.Entry<String, String> me = it.next();
			System.out.println(me.getKey() + " --> " + me.getValue());
		}
	}

	public static String removeParams(String url, String[] params) {
		String reg = null;
		StringBuffer ps = new StringBuffer();
		ps.append("(");
		for (int i = 0; i < params.length; i++) {
			ps.append(params[i]).append("|");
		}
		ps.deleteCharAt(ps.length() - 1);
		ps.append(")");
		reg = "(?<=[\\?&])" + ps.toString() + "=[^&]*&?";
		url = url.replaceAll(reg, "");
		url = url.replaceAll("(\\?|&+)$", "");
		return url;
	}

	@Test
	public void testUrl() {
		String url = "http://www.baidu.com?a=1&b=2&a=1&c=4";
		System.out.println(removeParams(url, new String[] { "a" }));
	}

	@Test
	@SuppressWarnings("all")
	public void jsonlib() {
		String jsonStr = "{\"a\":1}";
		net.sf.json.JSONObject jsonObj = net.sf.json.JSONObject.fromObject(jsonStr);
		// DateUtil.now(p, a)
		JSONObject j1 = JSON.parseObject(jsonStr);
	}

	// @Test
	// @SuppressWarnings("all")
	// public void jsonutil() throws Exception {
	// String s1 = "{\"a\":[{\"b\":[{\"c\":3}]}]}";
	// String s2 = "[{\"a\":[{\"b\":2}]}]";
	// Map<String, Object> m1 = JSONUtil.getMapFromJson(s1, String.class,
	// Object.class);
	// System.out.println(((Map) ((ArrayList) m1.get("a")).get(0)).get("b"));
	// Map<String, Object> m2 = JSONUtil.getJson2Map(s1);
	// System.out.println(m2.get("a"));
	// List<Map> l1 = JSONUtil.getListFromJson(s2, Map.class);
	// Map<String, Object> lm1 = l1.get(0);
	// System.out.println(lm1.get("a"));
	// List<Map> l2 = JSONUtil.getJson2List(s2, Map.class);
	// System.out.println(l2.get(0).get("a"));
	// }

	@Test
	@SuppressWarnings("all")
	public void jsonutil2() {
		String str = "[{\"id\":1,\"name\":\"小明\"}]";
		List<Map> students1 = JsonUtil.parseArray(str, Map.class);

		List<Student> students2 = null;
		try {
			students2 = JsonUtil.objectMapper.readValue(str, new TypeReference<List<Student>>() {
			});
		} catch (IOException e) {
		}
	}
}
