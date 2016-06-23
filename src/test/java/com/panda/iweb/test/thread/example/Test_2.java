package com.panda.iweb.test.thread.example;

import java.io.IOException;

/**
 * test wait/notify
 * 
 * @author chenlj
 * @Date 2016年6月18日 上午11:35:20
 */
public class Test_2 {
	private static Object lock = new Object();

	public static void main(String[] args) throws IOException {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				synchronized (lock) {
					try {
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println("子线程运行");
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		System.out.println("请输入回车键唤醒子线程");
		synchronized (lock) {
			System.out.println(t.getState());
			while (System.in.read() == 13) {
				lock.notify();
			}
		}
	}
}
