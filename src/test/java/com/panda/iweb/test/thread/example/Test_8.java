package com.panda.iweb.test.thread.example;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class DataCenter {
	private PipedInputStream pis = new PipedInputStream();
	private PipedOutputStream pos = new PipedOutputStream();

	public DataCenter() {
		try {
			pos.connect(pis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void write() {
		try {
			// while (true) {
			// String data = String.valueOf(System.nanoTime() + "");
			// System.out.println("写:" + data);
			// pos.write(data.getBytes());
			// Thread.sleep(1000);
			// }
			int o = 256;
			System.out.println("write:" + o);
			pos.write(o);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void read() {
		try {
			// byte[] byteArray = new byte[20];
			// while (true) {
			// int readLength = pis.read(byteArray);
			// while (readLength != -1) {
			// System.out.println("读:" + new String(byteArray, 0, readLength));
			// readLength = pis.read(byteArray);
			// }
			// Thread.sleep(1000);
			// }
			System.out.println("read:" + pis.read());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		if (pis != null) {
			try {
				pis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if (pos != null) {
			try {
				pos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

/**
 * 通过管道流进行线程间的通信
 * 
 * @author chenlj
 * @Date 2016年6月20日 上午11:14:13
 */
public class Test_8 {
	public static void main(String[] args) {
		DataCenter dataCenter = new DataCenter();
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				dataCenter.write();
			}
		});
		t1.start();

		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				dataCenter.read();
			}
		});
		t2.start();
	}
}
