package com.panda.iweb.util.common;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ReflectUtil {

	public static List<Field> getFields(Object obj) {
		List<Field> fields = new ArrayList<Field>();
		getFields(fields, obj.getClass(), obj);
		return fields;
	}

	private static void getFields(List<Field> fields, Class<?> clazz, Object obj) {
		fields.addAll(ArrayUtil.asList(clazz.getDeclaredFields()));
		Class<?> parent = clazz.getSuperclass();
		if (parent != null) {
			getFields(fields, parent, obj);
		}
	}
}
