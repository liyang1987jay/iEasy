package com.ieasy.config;

import io.swagger.annotations.Authorization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liyang
 * @projectName iEasy
 * @packageName com.ieasy.config
 * @description
 * @className RedisConfig
 * @createDate 2019-03-18 3:54 PM
 */
@Slf4j
@Configuration
public class RedisConfig {

    @Value("${spring.redis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.pool.max-wait}")
    private long maxWaitMillis;
    @Autowired
    private JedisConnectionFactory jedisConnectionFactory;

    @Bean
    public JedisPool jedisPool() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return new JedisPool(jedisPoolConfig,
                jedisConnectionFactory.getHostName(), jedisConnectionFactory.getPort(),
                jedisConnectionFactory.getTimeout(), jedisConnectionFactory.getPassword());
    }

    public static void main(String[] args) {
        System.out.println(0.3*6);
    }
}
