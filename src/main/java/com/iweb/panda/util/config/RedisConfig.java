package com.iweb.panda.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RedisConfig {

    @Value("${redis.host}")
    private String redisHost;
    @Value("${redis.port}")
    private String redisPort;
    @Value("${redis.password}")
    private String redisPassword;
    @Value("${redis.timeout}")
    private String redisTimeout;
    @Value("${redis.maxTotal}")
    private String redisMaxTotal;
    @Value("${redis.maxIdle}")
    private String redisMaxIdle;
    @Value("${redis.maxWaitMillis}")
    private String redisMaxWaitMillis;
    @Value("${redis.testOnBorrow}")
    private String redisTestOnBorrow;

    public String getRedisHost() {
        return redisHost;
    }

    public int getRedisPort() {
        return Integer.valueOf(redisPort);
    }

    public String getRedisPassword() {
        return redisPassword;
    }

    public int getRedisTimeout() {
        return Integer.valueOf(redisTimeout);
    }

    public int getRedisMaxTotal() {
        return Integer.valueOf(redisMaxTotal);
    }

    public int getRedisMaxIdle() {
        return Integer.valueOf(redisMaxIdle);
    }

    public int getRedisMaxWaitMillis() {
        return Integer.valueOf(redisMaxWaitMillis);
    }

    public boolean isRedisTestOnBorrow() {
        return Boolean.valueOf(redisTestOnBorrow);
    }

}
