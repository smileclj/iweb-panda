package com.panda.iweb.test.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

import com.panda.iweb.test.reflect.annotation.Max;
import com.panda.iweb.test.reflect.annotation.NotNull;
import com.panda.iweb.util.common.ReflectUtil;

public class Validate {
	public static String validate(Object obj) throws Exception {
		String message = "success";
		List<Field> fields = ReflectUtil.getFields(obj);
		for (Field field : fields) {
			field.setAccessible(true);
			Object value = field.get(obj);
			Annotation[] annotations = field.getAnnotations();
			for (Annotation annotation : annotations) {
				if (annotation.annotationType() == NotNull.class) {
					if (value == null) {
						message = field.getName() + " is null";
						return message;
					}
				}
				if (annotation.annotationType() == Max.class) {
					Method m_value = annotation.annotationType().getDeclaredMethod("value", new Class<?>[] {});
					Integer max = (Integer) value;
					Long config_max = (Long) m_value.invoke(annotation, new Object[] {});
					if (max > config_max) {
						message = field.getName() + " is greater than " + config_max;
					}
				}
			}
		}
		return message;
	}
}
