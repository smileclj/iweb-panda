package com.panda.iweb.test.guava;

import com.google.common.base.Objects;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.util.concurrent.RateLimiter;
import com.panda.iweb.test.guava.base.GuavaEntity;
import org.junit.Test;

import java.util.Optional;

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
    public void cache() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(10)
//                .expireAfterAccess(5,TimeUnit.SECONDS)
                .removalListener(new RemovalListener<String, String>() {
                    @Override
                    public void onRemoval(RemovalNotification<String, String> removalNotification) {
                        //只会在手动调用清除的时候才会触发回调，过期策略到而清除的是不会的
                        System.out.println(String.format("key:%s has removed", removalNotification.getKey()));
                    }
                }).build();
        cache.put("a", "1");
        System.out.println(cache.getIfPresent("a"));
        cache.invalidate("a"); //移出key:a
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(cache.getIfPresent("a"));
    }

    /**
     * ReteLimiter
     * <p>
     *     如果是控制并发数，可以用
     * </p>
     * @param
     */
    @Test
    public void rateLimiter() {
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 10; i++) {
            long start = System.currentTimeMillis();
            System.out.println(rateLimiter.acquire());
            long end = System.currentTimeMillis();
        }
    }

    public static void main(String[] args) {

    }
}
