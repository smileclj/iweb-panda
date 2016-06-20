package com.iweb.panda.thread.example;

class Factory {
	private Object lock = new Object();
	private String product;

	public void produce() {
		try {
			synchronized (lock) {
				while (product != null) {
					System.out.println(Thread.currentThread().getName() + "waiting");
					lock.wait(); // 等待被消费
				}
				System.out.println(Thread.currentThread().getName() + "running");
				product = System.currentTimeMillis() + "_" + System.nanoTime();
				// System.out.println("生产产品：" + product);
				lock.notify();
				// lock.notifyAll(); //解决假死，唤醒所有等待线程，使生产肯定能唤醒消费，消费肯定能唤醒生产
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void consume() {
		try {
			synchronized (lock) {
				while (product == null) {
					System.out.println(Thread.currentThread().getName() + "waiting");
					lock.wait(); // 等待被生产
				}
				System.out.println(Thread.currentThread().getName() + "running");
				// System.out.println("消费产品：" + product);
				product = null;
				lock.notify();
				// lock.notifyAll();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class Test_7 {
	public static void main(String[] args) throws InterruptedException {
		Factory factory = new Factory();

		for (int i = 0; i < 2; i++) {
			Thread provider = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						factory.produce();
					}
				}
			});
			provider.setName("生产者" + String.valueOf(i));
			provider.start();

			Thread consumer = new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						factory.consume();
					}
				}
			});
			consumer.setName("消费者" + String.valueOf(i));
			consumer.start();
		}

		Thread.sleep(5000);

		Thread[] actives = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
		Thread.currentThread().getThreadGroup().enumerate(actives);
		for (int i = 0; i < actives.length; i++) {
			System.out.println(actives[i].getName() + "_" + actives[i].getState());
		}
	}
}
