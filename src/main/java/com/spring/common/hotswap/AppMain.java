package com.spring.common.hotswap;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
public class AppMain {

    public static void main(String[] args) throws SQLException {
        hotswap();
    }


    public static void hotswap() {
        new Thread(() -> {
            while (true) {
                try {
                    // 每次都创建出一个新的类加载器
                    HotswapCL cl = new HotswapCL("D:\\ideaspace\\spring-study\\target\\classes", new String[]{"com.spring.common.hotswap.Foo"});

                    Class cls = cl.loadClass("com.spring.common.hotswap.Foo");
                    Object foo = cls.newInstance();

                    Method m = foo.getClass().getMethod("sayHello", new Class[]{});
                    m.invoke(foo);

                } catch (Exception ex) {
                    ex.printStackTrace();
                }

                try {
                    TimeUnit.SECONDS.sleep(6L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();
    }
}