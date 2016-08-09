package com.panda.iweb.util.common;

import com.panda.iweb.dto.CourseDto;
import com.panda.iweb.entity.Course;
import org.springframework.beans.BeanUtils;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by chenlj on 2016/8/9.
 */
public class BeanCopyUtil {

    /**
     * 对象拷贝，默认不忽略空值
     *
     * @param source
     * @param target
     * @throws Exception
     */
    public static void copyProperties(Object source, Object target) throws Exception {
        copyProperties(source, target, false);
    }

    /**
     * 对象拷贝，可选择忽略空值
     *
     * @param source
     * @param target
     * @param ignoreNull
     * @throws Exception
     */
    public static void copyProperties(Object source, Object target, boolean ignoreNull) throws Exception {
        copyProperties(source, target, null, ignoreNull);
    }

    /**
     * 对象拷贝，可选择忽略的属性
     *
     * @param source
     * @param target
     * @param ignoreProperties
     * @throws Exception
     */
    public static void copyProperties(Object source, Object target, String[] ignoreProperties) throws Exception {
        copyProperties(source, target, ignoreProperties, false);
    }

    /**
     * 对象拷贝，可选择忽略空值和需要忽略的值F
     *
     * @param source
     * @param target
     * @param ignoreProperties
     * @param ignoreNull
     * @throws Exception
     */
    public static void copyProperties(Object source, Object target, String[] ignoreProperties, boolean ignoreNull) throws Exception {
        Class targetClass = target.getClass();
        List<PropertyDescriptor> targetPds = getPropertyDescriptors(targetClass);
        List ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;

        for (PropertyDescriptor targetPd : targetPds) {
            Method writeMethod = targetPd.getWriteMethod(); //获得set方法
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod(); //获得get方法
                    //参数类型和返回类型一致
                    if (readMethod != null && writeMethod.getParameterTypes()[0].isAssignableFrom(readMethod.getReturnType())) {
                        if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                            readMethod.setAccessible(true);
                        }
                        Object setParam = readMethod.invoke(source, new Object[0]);
                        if (!(ignoreNull && setParam == null)) {
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }
                            writeMethod.invoke(target, new Object[]{setParam});
                        }
                    }
                }
            }
        }
    }

    private static List<PropertyDescriptor> getPropertyDescriptors(Class<?> clazz) throws IntrospectionException {
        List<PropertyDescriptor> pds = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            pds.add(getPropertyDescriptor(clazz, field.getName()));
        }
        return pds;
    }

    private static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) throws IntrospectionException {
        return new PropertyDescriptor(propertyName, clazz);
    }

    public static void main(String[] args) {
        Course course = new Course();
        course.setId(1);
        course.setName("小明");
        course.setCreateTime(new Date());

        CourseDto courseDto = new CourseDto();
        courseDto.setName("小红");
        try {
            BeanCopyUtil.copyProperties(courseDto, course, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
