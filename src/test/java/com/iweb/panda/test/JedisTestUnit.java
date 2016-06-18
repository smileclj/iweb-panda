package com.iweb.panda.test;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisTestUnit {
	private JedisPool pool;
	private Jedis jedis;

	@Before
	public void init() {
		// 默认是0号库
		JedisPoolConfig config = new JedisPoolConfig();
		pool = new JedisPool(config, "192.168.1.32", 6379, 2000, "123456");
		jedis = pool.getResource();
	}

	@Test
	public void set_get() {
		jedis.set("count", "0");
		System.out.println(jedis.get("count"));
	}

	@Test
	public void get() {
		System.out.println(jedis.get("name"));
	}

	@Test
	public void info() {
		System.out.println(jedis.info());
	}
}
