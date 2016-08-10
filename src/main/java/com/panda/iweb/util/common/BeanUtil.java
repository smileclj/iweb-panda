package com.panda.iweb.util.common;

import com.panda.iweb.dto.CourseDto;
import com.panda.iweb.entity.Course;
import net.sf.cglib.beans.BeanCopier;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BeanUtil {

    private static final Map<String, BeanCopier> BEAN_COPIERS = new HashMap<String, BeanCopier>();

    public static void copyProperties(Object dest, Object src) {
        String key = genKey(src.getClass(), dest.getClass());
        BeanCopier copier = null;
        if (!BEAN_COPIERS.containsKey(key)) {
            copier = BeanCopier.create(src.getClass(), dest.getClass(), false);
            BEAN_COPIERS.put(key, copier);
        } else {
            copier = BEAN_COPIERS.get(key);
        }
        copier.copy(src, dest, null);
    }

    private static String genKey(Class<?> srcClazz, Class<?> destClazz) {
        return srcClazz.getName() + destClazz.getName();
    }

    // 此方法比较耗性能
    // public static void copyProperties(Object dest, Object orig) throws IllegalAccessException,
    // InvocationTargetException {
    // BeanUtils.copyProperties(dest, orig);
    // }

    public static void main(String[] args) {
        Course course = new Course();
        course.setId(1);
        course.setName("小明");
        course.setCreateTime(new Date());

        CourseDto dto = new CourseDto();
        dto.setName("小红");

//        BeanUtil.copyProperties(course,dto);
//        System.out.println(course);

        try {
            PropertyUtils.copyProperties(course, dto);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        System.out.println(course);
    }
}
