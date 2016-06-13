package com.iweb.panda.dubbo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.panda.iweb.remote.IwebInterface;

public class DubboClient {
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
		context.start();
		IwebInterface iwebInterface = (IwebInterface) context.getBean("iwebInterface"); // 获取远程服务代理
		String hello = iwebInterface.sayHello("world"); // 执行远程方法
		System.out.println(hello); // 显示调用结果
		context.close();
	}
}
