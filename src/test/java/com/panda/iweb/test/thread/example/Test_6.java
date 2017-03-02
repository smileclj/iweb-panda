package com.panda.iweb.test.thread.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

class Task6 {
	private AtomicInteger counter = new AtomicInteger();

	public void add() {
		// synchronized ("lock") {
		counter.addAndGet(1);
		// }
	}

	public void print() {
		System.out.println(counter.get());
	}
}

public class Test_6 {
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