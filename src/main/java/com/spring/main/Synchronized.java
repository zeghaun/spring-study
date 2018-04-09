package com.spring.main;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2018/1/29
 */
public  class Synchronized {
    public   static void test1() {

        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + "---" + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException ie) {
            }
        }
    }

    public   void test2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + " : " + i);
            try {
                Thread.sleep(500);

            } catch (InterruptedException ie) {
            }
        }
    }

    public static void main(String[] args) {
        final Synchronized myt2 = new Synchronized();
        Thread test1 = new Thread(new Runnable() {
            public void run() {
                myt2.test1();
            }
        }, "test1");
        Thread test2 = new Thread(new Runnable() {
            public void run() {
                myt2.test2();
            }
        }, "test2");

        final Synchronized myt5 = new Synchronized();
        Thread a1 = new Thread(new Runnable() {
            public void run() {
                myt5.test1();
            }
        }, "a1");
        Thread a2 = new Thread(new Runnable() {
            public void run() {
                myt5.test2();
            }
        }, "a2");

        a1.start();
        a2.start();
        test1.start();
        test2.start();
//         TestRunnable tr=new TestRunnable();
//         Thread test3=new Thread(tr);
//         test3.start();
    }
}
