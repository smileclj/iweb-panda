package com.iweb.panda.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisUtil {

    private static final Logger logger         = LoggerFactory.getLogger(RedisUtil.class);
    // Redis服务器IP
    private static String       HOST           = "192.168.1.97";
    // Redis的端口号
    private static int          PORT           = 6379;
    // 访问密码
    private static String       PASSWORD       = "123456";
    // 可用连接实例的最大数目，默认值为8；
    // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)。
    private static int          MAX_TOTAL      = 1024;
    // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例，默认值也是8。
    private static int          MAX_IDLE       = 200;
    // 等待可用连接的最大时间，单位毫秒，默认值为-1，表示永不超时。如果超过等待时间，则直接抛出JedisConnectionException；
    private static int          MAX_WAIT       = 10000;
    private static int          TIMEOUT        = 10000;
    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    private static boolean      TEST_ON_BORROW = true;
    private static JedisPool    jedisPool      = null;

    // 初始化Redis连接池
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();
            config.setMaxTotal(MAX_TOTAL);
            config.setMaxIdle(MAX_IDLE);
            config.setMaxWaitMillis(MAX_WAIT);
            config.setTestOnBorrow(TEST_ON_BORROW);
            jedisPool = new JedisPool(config, HOST, PORT, TIMEOUT, PASSWORD);
        } catch (Exception e) {
            logger.error("jedisPool初始化失败...", e);
        }
    }

    // 获取Jedis实例
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                return jedisPool.getResource();
            } else {
                return null;
            }
        } catch (Exception e) {
            logger.error("获取jedis实例失败...", e);
            return null;
        }
    }

    // 释放jedis资源
    public static void close(final Jedis jedis) {
        if (jedis != null) {
            jedis.close();
        }
    }
}
