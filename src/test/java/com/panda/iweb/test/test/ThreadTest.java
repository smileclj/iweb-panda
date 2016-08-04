package com.panda.iweb.test.test;

import java.io.IOException;

public class ThreadTest {
	public static void main(String[] args) throws IOException {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				// try {
				// Thread.sleep(5000);
				// } catch (InterruptedException e) {
				// }
				try {
					while (true) {
						System.out.println("thread alive.");
						Thread.sleep(1000);
					}
				} catch (InterruptedException e) {
				}
			}
		});
		// t.setDaemon(true);
		t.start();
		return;
	}
}
