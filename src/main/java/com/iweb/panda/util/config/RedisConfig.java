package com.iweb.panda.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    @Value("${redis.host}")
    private String  redisHost;
    @Value("${redis.port}")
    private int     redisPort;
    @Value("${redis.password}")
    private String  redisPassword;
    @Value("${redis.timeout}")
    private int     redisTimeout;
    @Value("${redis.maxTotal}")
    private int     redisMaxTotal;
    @Value("${redis.maxIdle}")
    private int     redisMaxIdle;
    @Value("${redis.maxWaitMillis}")
    private int     redisMaxWaitMillis;
    @Value("${redis.testOnBorrow}")
    private boolean redisTestOnBorrow;

    public String getRedisHost() {
        return redisHost;
    }

    public int getRedisPort() {
        return redisPort;
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public int getRedisTimeout() {
        return redisTimeout;
    }

    public int getRedisMaxTotal() {
        return redisMaxTotal;
    }

    public int getRedisMaxIdle() {
        return redisMaxIdle;
    }

    public int getRedisMaxWaitMillis() {
        return redisMaxWaitMillis;
    }

    public boolean isRedisTestOnBorrow() {
        return redisTestOnBorrow;
    }

}
