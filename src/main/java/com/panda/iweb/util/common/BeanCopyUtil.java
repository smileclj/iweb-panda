package com.dfire.soa.boss.util;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huixiangdou on 2016/8/9.
 * 对象拷贝工具类
 */
public class BeanCopyUtil {

    /**
     * 对象拷贝，默认不忽略空值
     *
     * @param source
     * @param target
     * @throws Exception
     */
    public static void copyProperties(Object target, Object source) throws Exception {
        copyProperties(target, source, false);
    }

    /**
     * 对象拷贝，可选择忽略空值
     *
     * @param source
     * @param target
     * @param ignoreNull
     * @throws Exception
     */
    public static void copyProperties(Object target, Object source, boolean ignoreNull) throws Exception {
        copyProperties(target, source, null, ignoreNull);
    }

    /**
     * 对象拷贝，可选择忽略的属性
     *
     * @param source
     * @param target
     * @param ignoreProperties
     * @throws Exception
     */
    public static void copyProperties(Object target, Object source, String[] ignoreProperties) throws Exception {
        copyProperties(target, source, ignoreProperties, false);
    }

    /**
     * 对象拷贝，可选择忽略空值和需要忽略的值
     *
     * @param source
     * @param target
     * @param ignoreProperties
     * @param ignoreNull
     * @throws Exception
     */
    public static void copyProperties(Object target, Object source, String[] ignoreProperties, boolean ignoreNull) throws Exception {
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

    private static List<PropertyDescriptor> getPropertyDescriptors(Class<?> clazz) {
        List<PropertyDescriptor> pds = new ArrayList<>();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            PropertyDescriptor pd = getPropertyDescriptor(clazz, field.getName());
            if (pd != null) {
                pds.add(pd);
            }
        }
        return pds;
    }

    private static PropertyDescriptor getPropertyDescriptor(Class<?> clazz, String propertyName) {
        PropertyDescriptor pd = null;
        try {
            pd = new PropertyDescriptor(propertyName, clazz);
        } catch (IntrospectionException e) {
        }
        return pd;
    }
}
