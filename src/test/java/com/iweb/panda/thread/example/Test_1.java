package com.iweb.panda.thread.example;

/**
 * test isAlive
 * 
 * @author chenlj
 * @Date 2016年6月18日 上午11:35:00
 */
public class Test_1 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		int b = 3;
		while (b > 0) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			System.out.println(t.isAlive());
			if (!t.isAlive()) {
				b--;
			}
		}
	}
}
