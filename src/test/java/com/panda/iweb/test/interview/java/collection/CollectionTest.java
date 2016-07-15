package com.panda.iweb.test.interview.java.collection;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

public class CollectionTest {
	@Test
	public void hashMapItr1() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(3, "c");
		map.put(2, "b");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			for (Integer in : map.keySet()) {
				System.out.println("key:" + in + ":" + "value:" + map.get(in));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	@Test
	public void hashMapItr2() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(3, "c");
		map.put(2, "b");
		long start = System.currentTimeMillis();
		for (int i = 0; i < 5; i++) {
			for (Map.Entry<Integer, String> entry : map.entrySet()) {
				System.out.println("key:" + entry.getKey() + ":" + "value:" + entry.getValue());
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}

	@Test
	public void linkedHashMap() {
		HashMap<Integer, String> map = new LinkedHashMap<Integer, String>();
		map.put(1, "a");
		map.put(3, "c");
		map.put(2, "b");
		for (Integer i : map.keySet()) {
			System.out.println("key:" + i + ":" + "value:" + map.get(i));
		}
	}

}
