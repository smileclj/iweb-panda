package com.panda.iweb.test.thread.example;

/**
 * 利用 interrupt 中断线程
 * 也可以采用抛出异常的方式
 * 
 * @author chenlj
 * @Date 2016年6月18日 下午12:14:54
 */
public class Test_3 {
	public static void main(String[] args) {
		Runnable r = new Runnable() {
			private int step = 0;

			@Override
			public void run() {
				while (!Thread.currentThread().isInterrupted()) {
					if (step == 10) {
						Thread.currentThread().interrupt();
					}
					System.out.println("子线程 run:" + step);
					step++;
				}
			}
		};
		Thread t = new Thread(r);
		t.start();
		// t.interrupt();
	}
}
