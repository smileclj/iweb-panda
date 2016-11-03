package com.panda.iweb.test.thread;

import com.panda.iweb.test.entity.Run;
import org.junit.Test;

/**
 * Created by huixiangdou on 2016/10/26.
 */
public class ThreadTest {
    @Test
    public void getProcess() {
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public static void main(String[] args) {
        Runnable r = new Run() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "启动");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(r);
            t.start();
        }
    }
}
