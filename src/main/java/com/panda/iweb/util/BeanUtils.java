package com.panda.iweb.util;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.concurrent.Callable;

/**
 * Created by dami on 2015/10/14 0014.
 */
public class BeanUtils {
    private static Logger logger = LoggerFactory.getLogger(BeanUtils.class);
    private static Cache<String, List<Field>> classFieldCache = CacheBuilder.newBuilder().maximumSize(20).build();

    public static <T> T copyBean(Object srcObj, Class<T> tarClass) throws BizException {
        if(null == tarClass || null == srcObj){
            return null;
        }
        try {
            T tarObj = tarClass.newInstance();
            copyBean(srcObj,tarObj);
            return tarObj;
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            throw new BizException("服务器出现异常！");
        }

    }

    public static <T> void copyBean(final Object srcObj, final T tarObj) throws BizException {
        try {
            //null抛错
            if (null == srcObj || null == tarObj) {
                return;
            }
            //得到所有的字段
            List<Field> tarFields = classFieldCache.get(tarObj.getClass().getName(), new Callable<List<Field>>() {
                @Override
                public List<Field> call() throws Exception {
                    return getAllField(tarObj.getClass(), null);
                }
            });
            List<Field> srcFields = classFieldCache.get(srcObj.getClass().getName(), new Callable<List<Field>>() {
                @Override
                public List<Field> call() throws Exception {
                    return getAllField(srcObj.getClass(), null);
                }
            });
            //没有字段，不需要设置
            if ((null == tarFields || tarFields.size() == 0) ||
                    (null == srcFields || srcFields.size() == 0)) {
                return;
            }

            //获取字段签名以及字段对应关系
            Map<String, Method> tarMethodMap = new HashMap<>();
            Map<String, Field> srcFieldMap = new HashMap<>();

            String fieldSign;
            for (Field field : srcFields) {
                fieldSign = field.getName();
                srcFieldMap.put(fieldSign, field);
            }
            Method method;
            Class tarClass = tarObj.getClass();
            for (Field field : tarFields) {
                fieldSign = field.getName();
                if (null != srcFieldMap.get(fieldSign)) {
                    try {
                        method = tarClass.getMethod("set" + upperFirstChar(fieldSign), field.getType());
                        tarMethodMap.put(fieldSign, method);
                    }catch (Exception ex){
                        logger.info(ex.getMessage(),ex);
                    }
                }
            }

            //设置字段的值
            Field srcField;
            Object srcValue;
            String tmpSrcValue;
            String srcSimpleName;
            String paramClassSimpleName;
            for (Map.Entry<String, Method> entry : tarMethodMap.entrySet()) {
                method = entry.getValue();
                fieldSign = entry.getKey();

                srcField = srcFieldMap.get(fieldSign);
                if (null != srcField) {
                    srcField.setAccessible(true);
                    srcValue = srcField.get(srcObj);
                    if (null != srcValue) {
                        paramClassSimpleName = method.getParameterTypes()[0].getSimpleName();
                        srcSimpleName = upperFirstChar(srcField.getType().getSimpleName());
                        if(!paramClassSimpleName.equals(srcSimpleName)) {
                            if (paramClassSimpleName.equals("Short")) {
                                tmpSrcValue = String.valueOf(srcValue);
                                method.invoke(tarObj, Short.valueOf(tmpSrcValue));
                            } else if (paramClassSimpleName.equals("Integer")) {
                                tmpSrcValue = String.valueOf(srcValue);
                                method.invoke(tarObj, Integer.valueOf(tmpSrcValue));
                            } else if (paramClassSimpleName.equals("Double")) {
                                tmpSrcValue = String.valueOf(srcValue);
                                method.invoke(tarObj, Double.valueOf(tmpSrcValue));
                            } else {
                                method.invoke(tarObj, srcValue);
                            }
                        }else{
                            method.invoke(tarObj, srcValue);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage(),ex);
            throw new BizException("服务器出现异常！");
        }
    }

    /**
     * 获取全部的Field
     *
     * @param entityClass
     * @param fieldList
     * @return
     */
    private static List<Field> getAllField(Class<?> entityClass, List<Field> fieldList) {
        if (fieldList == null) {
            fieldList = new LinkedList<Field>();
        }
        if (entityClass.equals(Object.class)) {
            return fieldList;
        }
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            //排除静态字段，解决bug#2
            if (!Modifier.isStatic(field.getModifiers())) {
                fieldList.add(field);
            }
        }
        Class<?> superClass = entityClass.getSuperclass();
        if (superClass != null
                && !superClass.equals(Object.class)
                || (!Map.class.isAssignableFrom(superClass)
                && !Collection.class.isAssignableFrom(superClass))) {
            return getAllField(entityClass.getSuperclass(), fieldList);
        }
        return fieldList;
    }

    private static String upperFirstChar(String str) {
        char[] charArr = str.toCharArray();
        StringBuilder builder = new StringBuilder();
        char firstUpper = charArr[0];
        if ((firstUpper >= 'A' && firstUpper <= 'Z') || (firstUpper >= 'a' && firstUpper <= 'z')) {
            firstUpper = (char) (firstUpper - 32);
            builder.append(firstUpper);
            builder.append(charArr, 1, charArr.length - 1);
            return builder.toString();
        } else {
            return str;
        }
    }
}
