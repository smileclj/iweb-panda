package com.iweb.panda.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.panda.iweb.remote.IwebInterface;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class DubboTestUnit {
	@Resource
	private IwebInterface iwebInterfaceClient;

	@Test
	public void sayHello() {
		System.out.println(iwebInterfaceClient.sayHello("小明"));
	}

}
