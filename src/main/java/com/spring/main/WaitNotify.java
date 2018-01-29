package com.spring.main;

import java.util.concurrent.TimeUnit;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2018/1/29
 */
public class WaitNotify {
    static boolean flag = true;
    static  Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Wait(), "wait thread");
        A.start();
        TimeUnit.SECONDS.sleep(2);
        Thread B = new Thread(new Notify(), "notify thread");
        B.start();
    }

    static class Wait implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {

                while (flag) {
                    try {
                        System.out.println(Thread.currentThread() + " flag is true");
                        lock.wait();
                        System.out.println(Thread.currentThread() + " flag is true2");
                    } catch (InterruptedException e) {

                    }
                }
                System.out.println(Thread.currentThread() + " flag is false");
            }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                flag = false;
                lock.notifyAll();
                try {
                    System.out.println(Thread.currentThread() + " xxxxx");
                    TimeUnit.SECONDS.sleep(7);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
