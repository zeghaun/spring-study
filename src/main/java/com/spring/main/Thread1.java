package com.spring.main;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/23
 */
public class Thread1 implements Runnable {
    private static int len = 10;

    public void run() {
        for (int i = 0; i < len; i++) {
            System.out.println("   " + Thread.currentThread().getName() + " start " + i);

        }
        synchronized (this) {
            for (int i = 0; i < len; i++) {
                System.out.println(Thread.currentThread().getName() + " synchronized loop " + i);

            }
        }
        for (int i = 0; i < len; i++) {
            System.out.println("   " + Thread.currentThread().getName() + " end " + i);

        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread ta = new Thread(t1, "A");
        Thread tb = new Thread(t1, "B");
        ta.start();
        tb.start();
    }
}