package com.iweb.panda.test;

import org.junit.Test;

import redis.clients.jedis.Jedis;

import com.iweb.panda.util.RedisUtil;

public class JedisTest {

    @Test
    public void test1() {
        Jedis jedis = RedisUtil.getJedis();
        if (jedis != null) {
            jedis.set("name", "小明");
            System.out.println(jedis.get("name"));
        }
    }

    @Test
    public void info() {
        Jedis jedis = RedisUtil.getJedis();
        if (jedis != null) {
            System.out.println(jedis.info());
        }
    }
}
