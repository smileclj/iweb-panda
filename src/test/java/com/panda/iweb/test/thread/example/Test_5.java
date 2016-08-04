package com.panda.iweb.test.thread.example;

/**
 * 死锁
 * 
 * @author chenlj
 * @Date 2016年6月18日 下午2:54:29
 */

class Task5 implements Runnable {
	private String name;
	private Object lock1 = new Object();
	private Object lock2 = new Object();

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		if (name.equals("a")) {
			synchronized (lock1) {
				try {
					System.out.println("name:" + name);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock2) {
					System.out.println("lock1->lock2");
				}
			}
		}

		if (name.equals("b")) {
			synchronized (lock2) {
				try {
					System.out.println("name:" + name);
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				synchronized (lock1) {
					System.out.println("lock2->lock1");
				}
			}
		}
	}
}

public class Test_5 {
	public static void main(String[] args) {
		Task5 task5 = new Task5();
		task5.setName("a");
		Thread t1 = new Thread(task5);
		t1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
		}
		task5.setName("b");
		Thread t2 = new Thread(task5);
		t2.start();
	}
}
