package com.iweb.panda.test;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import redis.clients.jedis.Jedis;

import com.iweb.panda.common.constants.RabbitMqConstant;
import com.iweb.panda.util.JsonUtil;
import com.iweb.panda.util.RabbitMqUtil;
import com.iweb.panda.util.RedisUtil;
import com.iweb.panda.util.config.RedisConfig;
import com.rabbitmq.client.AMQP.BasicProperties;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class testRelyOnSpringUnit implements ApplicationContextAware {

    private static final Logger logger = LoggerFactory.getLogger(testRelyOnSpringUnit.class);
    private ApplicationContext  context;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.context = context;
    }

    @Resource
    private RedisUtil    redisUtil;
    @Resource
    private RabbitMqUtil rabbitMqUtil;

    @Test
    public void testRedis() {
        Jedis jedis = redisUtil.getJedis();
        if (jedis != null) {
            System.out.println(jedis.get("name"));
        }
    }

    @Test
    public void testProp() {
        RedisConfig redisConfig = (RedisConfig) context.getBean("redisConfig");
        System.out.println(JsonUtil.toJsonString(redisConfig));
    }

    @Test
    public void publishRabbitMq() {
        Channel channel = rabbitMqUtil.getChannel();
        if (channel != null) {
            try {
                channel.basicPublish(RabbitMqConstant.TEST_EXCHANGE, "test", null, "hello world3".getBytes());
            } catch (IOException e) {
                logger.error("发布MQ消息失败");
            } finally {
                try {
                    channel.close();
                } catch (IOException | TimeoutException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test
    public void consumeRabbitMq() {
        Channel channel = rabbitMqUtil.getChannel();
        if (channel != null) {
            try {
                channel.basicConsume(RabbitMqConstant.TEST_QUEUE, new DefaultConsumer(channel) {

                    @Override
                    public void handleDelivery(String consumerTag, Envelope envelope, BasicProperties properties,
                                               byte[] body) throws IOException {
                        logger.info("消费消息,通道:{},消息内容:{}", RabbitMqConstant.TEST_QUEUE, new String(body));
                        channel.basicAck(envelope.getDeliveryTag(), false);
                    }
                });
            } catch (IOException e) {
                logger.error("消费MQ消息失败");
            }
        }
    }
}
