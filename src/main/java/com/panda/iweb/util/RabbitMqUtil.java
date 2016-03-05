package com.panda.iweb.util;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.panda.iweb.util.config.RabbitMqConfig;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

@Component
public class RabbitMqUtil {

    private final Logger   logger = LoggerFactory.getLogger(getClass());
    @Resource
    private RabbitMqConfig config;
    private Connection     conn;

    private void initRabbitMq() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUsername(config.getUserName());
        factory.setPassword(config.getPassword());
        factory.setVirtualHost(config.getVirtualHost());
        factory.setHost(config.getHost());
        factory.setPort(config.getPort());
        conn = factory.newConnection();
    }

    // channel使用完后需关闭
    public Channel getChannel() {
        Channel channel = null;
        if (conn != null && conn.isOpen()) {
            try {
                channel = conn.createChannel();
            } catch (IOException e) {
                logger.error("rabbitMq并未开启连接");
            }
        } else {
            try {
                initRabbitMq();
                channel = conn.createChannel();
            } catch (IOException | TimeoutException e) {
                logger.error("rabbitMq初始化失败");
            }
        }
        return channel;
    }
}
