package com.spring.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Pattern;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@Service
@Transactional
public class AppMain {

    private AtomicReference<Thread> owner = new AtomicReference<>();

    boolean isLocked = false;

    int lockCount = 0;

    Thread threadLocal = null;

    public void lock() throws InterruptedException {
        Thread thread = Thread.currentThread();
        while (isLocked && thread != threadLocal) {
            wait();
        }



    }

    public void unlock() {
        if (Thread.currentThread() == this.threadLocal) {
            lockCount--;
            if (lockCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

    public static void main(String[] args) throws Exception {


        Integer i = 1280, j = 1280;
        if(i==j){
            System.out.println("ddd");
        }


        // 创建两个Person对象，它们的id分别是101和102。
        Person p1 = new Person(101);
        Person p2 = new Person(102);
        // 新建AtomicReference对象，初始化它的值为p1对象
        AtomicReference ar = new AtomicReference(p1);
        // 通过CAS设置ar。如果ar的值为p1的话，则将其设置为p2。
        ar.compareAndSet(p1, p2);

        Person p3 = (Person) ar.get();
        System.out.println("p3 is " + p3);
        System.out.println("p3.equals(p1)=" + p3.equals(p1));
    }


    public String getPreviousDay(String today) {
        Date t = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyMMdd");

        return null;
    }

    public void test() {

        Pattern pattern = Pattern.compile("^[1-9][0-9]{11}$");
        System.out.println(pattern.matcher("000100000000").matches());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test/applicationContext-jpa.xml");

        AppMain c = (AppMain) ctx.getBean("appMain");

        System.out.println("中文中文中".length());
    }

    private static void log(String str) {
        System.out.println(str);
    }


    public static String GetMD5Code(String strObj) {
        String resultString = null;
        try {
            resultString = new String(strObj);
            MessageDigest md = MessageDigest.getInstance("MD5");
            // md.digest() 该函数返回值为存放哈希值结果的byte数组
//            resultString = byteToString(md.digest(strObj.getBytes()));
        } catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        return resultString;
    }

}


class Person {
    volatile int id;

    public Person(int id) {
        this.id = id;
    }

    public String toString() {
        return "id:" + id;
    }
}