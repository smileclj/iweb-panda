package com.panda.iweb.test.guava;

import com.google.common.base.Objects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.panda.iweb.test.guava.base.GuavaEntity;
import org.junit.Test;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * Created by huixiangdou on 2016/8/5.
 */
public class GuavaTest {
    /**
     * 基本工具类
     */

    //optional
    @Test
    public void optional() {
        Optional<Integer> o = Optional.of(5);
        System.out.println(o.get());
    }

    //objects
    @Test
    public void objects() {
        GuavaEntity entity = new GuavaEntity(1, "1");
        System.out.println(Objects.hashCode(entity));
        System.out.println(java.util.Objects.hashCode(entity));
        System.out.println(entity.hashCode());
    }

    /**
     * 缓存
     */
    @Test
    public void cache(){
        Cache cache = CacheBuilder.newBuilder().maximumSize(10000).expireAfterWrite(1, TimeUnit.MINUTES).build();
        cache.put("a","1");
    }
}
