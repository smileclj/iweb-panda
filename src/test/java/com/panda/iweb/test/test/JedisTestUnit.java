package com.panda.iweb.test.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.HessianFactory;
import com.panda.iweb.entity.Student;

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
		pool = new JedisPool(config, "192.168.1.66", 6379, 2000, "123456");
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

	@Test
	public void saveObject() throws IOException {
		Student s = new Student();
		s.setId(1);
		s.setName("小明");
		s.setSex(1);
		s.setCreateTime(new Date());

		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		HessianFactory factory = new HessianFactory();
		Hessian2Output out = factory.createHessian2Output(bos);
		out.startMessage();
		out.writeObject(s);
		out.completeMessage();
		out.close();
		byte[] dataw = bos.toByteArray();
		jedis.set("student".getBytes(), dataw);

		byte[] datar = jedis.get("student".getBytes());
		ByteArrayInputStream bin = new ByteArrayInputStream(datar);
		Hessian2Input in = factory.createHessian2Input(bin);
		in.startMessage();
		Student ss = (Student) in.readObject();
		in.completeMessage();
		in.close();
		bin.close();
		System.out.println(ss);
		
	}
}
