//package com.iweb.panda.util;
//
//import javax.annotation.Resource;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import redis.clients.jedis.Jedis;
//import redis.clients.jedis.JedisPool;
//import redis.clients.jedis.JedisPoolConfig;
//
//import com.iweb.panda.util.config.RedisConfig;
//
//@Component
//public class RedisUtil {
//
//    private final Logger logger    = LoggerFactory.getLogger(getClass());
//    @Resource
//    private RedisConfig  redisConfig;
//
//    private JedisPool    jedisPool = null;
//
//    public RedisUtil(){
//        try {
//            JedisPoolConfig config = new JedisPoolConfig();
//
//            config.setMaxTotal(redisConfig.getRedisMaxTotal());
//            config.setMaxIdle(redisConfig.getRedisMaxIdle());
//            config.setMaxWaitMillis(redisConfig.getRedisMaxWaitMillis());
//            config.setTestOnBorrow(redisConfig.isRedisTestOnBorrow());
//            jedisPool = new JedisPool(config, redisConfig.getRedisHost(), redisConfig.getRedisPort(),
//                                      redisConfig.getRedisTimeout(), redisConfig.getRedisPassword());
//        } catch (Exception e) {
//            logger.error("jedisPool初始化失败...", e);
//        }
//    }
//
//    // 获取Jedis实例
//    public synchronized Jedis getJedis() {
//        try {
//            if (jedisPool != null) {
//                return jedisPool.getResource();
//            } else {
//                return null;
//            }
//        } catch (Exception e) {
//            logger.error("获取jedis实例失败...", e);
//            return null;
//        }
//    }
//
//    // 释放jedis资源
//    public void close(final Jedis jedis) {
//        if (jedis != null) {
//            jedis.close();
//        }
//    }
//}
