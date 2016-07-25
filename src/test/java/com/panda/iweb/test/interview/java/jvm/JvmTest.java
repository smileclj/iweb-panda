package com.panda.iweb.test.interview.java.jvm;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JvmTest {
	@Test
	// -Xms20M -Xmx20M
	public void jvmInfo() {
		Runtime runTime = Runtime.getRuntime();
		long totalMem = runTime.totalMemory() / 1024 / 1024;
		long freeMem = runTime.freeMemory() / 1024 / 1024;
		long avaiableP = runTime.availableProcessors();
		long maxMem = runTime.maxMemory() / 1024 / 1024;
		System.out.println("总内存是：" + totalMem + "m");
		System.out.println("空闲内存是：" + freeMem + "m");
		System.out.println("最大内存是：" + maxMem + "m");
		System.out.println("总核数：" + avaiableP + "个");
	}

	@Test
	public void stackOverFlow() {

	}

	@Test
	// -Xms20m -Xmx20m
	public void outOfMemory() {
		List<Object> list = new ArrayList<Object>();
		int count = 0;

		try {
			while (true) {
				list.add(new Object());
				count++;
			}
		} catch (Exception e) {
			System.out.println(count);
			e.printStackTrace();
		}
	}

	@Test
	// -Xloggc:D:/gc.log
	public void gc() {
		System.gc();
	}

	@Test
	// -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	// -XX:SurvivorRatio=8
	public void allocation() {
		// byte[] a1, a2, a3, a4;
		// int one = 1024 * 1024;
		// a1 = new byte[2 * one];
		// a2 = new byte[2 * one];
		// a3 = new byte[2 * one];
		// a4 = new byte[4 * one];
	}

	@Test
	// -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails
	// -XX:SurvivorRatio=8
	public void allocation2() {
		// byte[] a1, a2, a3;
		// int one = 1024 * 1024;
		// a1 = new byte[1024];
		// a2 = new byte[4096];
		// a3 = new byte[3000]; // 触发GC
		// a3 = null;
		// a3 = new byte[3 * one];
	}

	public static void main(String[] args) {
		List<Object> list = new ArrayList<Object>();
		int count = 0;

		try {
			while (true) {
				list.add(new Object());
				count++;
			}
		} catch (Exception e) {
			System.out.println(count);
			e.printStackTrace();
		}
	}
}
