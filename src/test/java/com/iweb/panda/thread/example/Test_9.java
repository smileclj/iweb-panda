package com.iweb.panda.thread.example;

/**
 * 测试join 主线程等待子线程结束
 * 
 * @author chenlj
 * @Date 2016年6月21日 上午11:45:22
 */
public class Test_9 {
	private static int counter = 0;

	public static void main(String[] args) {
		try {
			Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
					counter += 10;
				}
			});
			t.start();
			t.join();
			System.out.println(counter);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
