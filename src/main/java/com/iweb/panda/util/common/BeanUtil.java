package com.iweb.panda.util.common;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BeanUtil {

    private static final Logger logger = LoggerFactory.getLogger(BeanUtil.class);

    public static void copyProperties(Object dest, Object orig) throws IllegalAccessException,
                                                               InvocationTargetException {
        try {
            BeanUtils.copyProperties(dest, orig);
        } catch (IllegalAccessException | InvocationTargetException e) {
            logger.error("对象拷贝失败", e);
            throw e;
        }
    }
}
