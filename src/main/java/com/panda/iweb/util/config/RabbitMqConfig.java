package com.panda.iweb.util.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConfig {

    @Value("${rabbitmq.host}")
    private String host;
    @Value("${rabbitmq.port}")
    private String port;
    @Value("${rabbitmq.virtualHost}")
    private String virtualHost;
    @Value("${rabbitmq.userName}")
    private String userName;
    @Value("${rabbitmq.password}")
    private String password;

    public String getHost() {
        return host;
    }

    public int getPort() {
        return Integer.valueOf(port);
    }

    public String getVirtualHost() {
        return virtualHost;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

}
