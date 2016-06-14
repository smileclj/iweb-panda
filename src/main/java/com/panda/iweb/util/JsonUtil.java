package com.panda.iweb.util;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.CollectionType;

public class JsonUtil {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtil.class);
	public final static ObjectMapper objectMapper = new ObjectMapper();

	static {
		// 反序列化配置
		objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		// 序列化配置
		objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
	}

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
			return objectMapper.readValue(text, getCollectionType(List.class, clazz));
		} catch (IOException e) {
			logger.error("将字符串:{}反序列化为list出错:{}", text, e);
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("all")
	private static CollectionType getCollectionType(Class<? extends Collection> collectionClass, Class<?> elementClass) {
		return objectMapper.getTypeFactory().constructCollectionType(collectionClass, elementClass);
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

	public static void main(String[] args) {
		Map<String, String> m = new HashMap<String, String>();
		m.put("a", "a");
		m.put("b", "b");
		// JsonUtil.toJsonString(m)
	}
}
