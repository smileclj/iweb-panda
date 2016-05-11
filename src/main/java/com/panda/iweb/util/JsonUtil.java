package com.panda.iweb.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	private final static ObjectMapper objectMapper = new ObjectMapper();

	public static String toJsonString(Object o) {
		try {
			return objectMapper.writeValueAsString(o);
		} catch (JsonProcessingException e) {
			logger.error("将对象:{}序列化为json字符串出错:{}", o, e);
			throw new RuntimeException(e);
		}
	}

	public static <T> T parseObject(String text, Class<T> clazz) {
		try {
			return objectMapper.readValue(text, clazz);
		} catch (IOException e) {
			logger.error("将字符串:{}反序列化为对象出错:{}", text, e);
			throw new RuntimeException(e);
		}
	}

	public static <T> List<T> parseArray(String text, Class<T> clazz) {
		try {
			return objectMapper.readValue(text, new TypeReference<List<T>>() {
			});
		} catch (IOException e) {
			logger.error("将字符串:{}反序列化为list出错:{}", text, e);
			throw new RuntimeException(e);
		}
	}

	public static <K, V> Map<K, V> parseMap(String text, Class<K> k, Class<V> v) throws Exception {
		try {
			return objectMapper.readValue(text, new TypeReference<Map<K, V>>() {
			});
		} catch (Exception e) {
			logger.error("将json字符串 {} 转换成Map对象时发生异常 {}", text, e);
			throw e;
		}
	}
	//
	// public static JSONObject parseObject(String text) {
	// try {
	// return JSON.parseObject(text);
	// } catch (JSONException e) {
	// logger.error("将字符串:{}反序列化为JSONObject出错:{}", text, e);
	// throw new RuntimeException(e);
	// }
	// }
	//
	// public static JSONArray parseArray(String text) {
	// try {
	// return JSON.parseArray(text);
	// } catch (JSONException e) {
	// logger.error("将字符串:{}反序列化为JSONArray出错:{}", text, e);
	// throw new RuntimeException(e);
	// }
	// }
}
