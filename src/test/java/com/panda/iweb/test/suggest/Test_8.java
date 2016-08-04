package com.panda.iweb.test.suggest;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Test_8 {
	public static void main(String[] args) {
		Callable<Integer> c = new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				TimeUnit.MILLISECONDS.sleep(10000);
				return 1;
			}
		};

		// Runnable r = new Runnable() {
		// @Override
		// public void run() {
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// }
		// }
		// };

		ExecutorService pool = Executors.newFixedThreadPool(1);
		Future<Integer> f = pool.submit(c);
		while (!f.isDone()) {
			System.out.print("#");
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
			}
		}
		try {
			System.out.println("\r\n计算完成，结果是:" + f.get());
		} catch (InterruptedException | ExecutionException e) {
		}
	}
}
