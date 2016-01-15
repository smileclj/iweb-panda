package com.iweb.panda.test;

import java.util.Locale;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.iweb.panda.entity.Prop;
import com.iweb.panda.util.JsonUtil;
import com.iweb.panda.util.config.RedisConfig;
import com.rabbitmq.tools.json.JSONUtil;

import redis.clients.jedis.Jedis;

// import com.iweb.panda.util.RedisUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testRelyOnSpring implements ApplicationContextAware {

    private ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    // @Resource
    // private RedisUtil redisUtil;

    // @Test
    // public void testRedis() {
    // Jedis jedis = redisUtil.getJedis();
    // if (jedis != null) {
    // System.out.println(jedis.get("name"));
    // }
    // }

    @Test
    public void testProp() {
        RedisConfig redisConfig = (RedisConfig) context.getBean("redisConfig");
        System.out.println(JsonUtil.toJsonString(redisConfig));
    }
}
