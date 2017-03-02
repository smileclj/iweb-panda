package com.panda.iweb.test.thread.example;

import java.util.concurrent.CountDownLatch;

//测试字符串作为同步锁
class Task4 {
	private int counter = 0;

	public void add() {
		synchronized ("lock") {
			counter++;
		}
	}

	public void print() {
		System.out.println(counter);
	}
}

public class Test_4 {
	private static int threadNum = 10000;
	private static CountDownLatch latch = new CountDownLatch(threadNum);

	public static void main(String[] args) throws InterruptedException {
		final Task4 task4 = new Task4();
		Runnable r = new Runnable() {
			@Override
			public void run() {
				task4.add();
				latch.countDown();
			}
		};
		for (int i = 0; i < threadNum; i++) {
			Thread t = new Thread(r);
			t.start();
		}
		latch.await();
		task4.print();
	}
}
