package com.spring.main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2018/3/24
 */
public class ThreadPool {

    public static void main(String[] args) {
        newFixedThreadPool();
        System.out.println("all out");
    }

    public static void newFixedThreadPool() {
        ExecutorService fixedThreadPool =Executors. newFixedThreadPool(3);
        for (int i =1; i<=5;i++){
            final int index=i ;
            fixedThreadPool.execute(new Runnable(){
                @Override
                public void run() {
                    try {
                        System.out.println("第" +index + "个线程" +Thread.currentThread().getName());
                        Thread.sleep(20000);
                    } catch(InterruptedException e ) {
                        e .printStackTrace();
                    }
                }

            });
            System.out.println("第" +index + "个线程" +Thread.currentThread().getName()+"   out");
        }
    }

    public void cachedThreadPool() {
        ExecutorService cacheThreadPool = Executors.newCachedThreadPool();
        for (int i = 1; i <= 5; i++) {
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cacheThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("第" + index + "个线程" + Thread.currentThread().getName());
                }
            });
        }
    }
}
