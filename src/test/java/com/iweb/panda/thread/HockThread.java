package com.iweb.panda.thread;

public class HockThread extends Thread {

	@Override
	public void run() {
		System.out.println("钩子线程");
	}

}
