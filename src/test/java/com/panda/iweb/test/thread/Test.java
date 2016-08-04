package com.panda.iweb.test.thread;

public class Test {
	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new HockThread());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("主线程结束");
	}
}
