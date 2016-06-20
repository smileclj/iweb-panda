package com.panda.iweb.util.common;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtil {
	public static <T> List<T> asList(T[] ts) {
		List<T> list = new ArrayList<T>();
		for (T t : ts) {
			list.add(t);
		}
		return list;
	}
}
