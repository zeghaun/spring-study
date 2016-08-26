package com.spring.main;

import com.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@Service
@Transactional
public class AppMain {

    @Autowired
    private TestRepository ur;

    public void add(Demo um) {
        ur.save(um);
    }

    public void delete(int id) {
        ur.deleteById(id);
    }

    public static void main(String[] args) throws SQLException {

//        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//
//        SessionFactory session =(SessionFactory) BeanFactory.getBean("sessionFactory");
//
//        AppMain c = (AppMain) ctx.getBean("appMain");
//        Demo um = new Demo();
//        um.setAge(15);
//        um.setName("zeghaun");
//        um.setRemark("zeghaun");
//        c.add(um);
//
//        c.delete(11146);
        List<Integer> list = new ArrayList<>();
        String s = "";
        for (int i = 250; i < 1350; i++) {
            s += "," + i;
        }
        System.out.println(s);
        Date t = new Date();
        System.out.println(DateFormat.getDateInstance().format(null));
    }

    public void test() {

        Pattern pattern = Pattern.compile("^[1-9][0-9]{11}$");
        System.out.println(pattern.matcher("000100000000").matches());
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test/applicationContext-jpa.xml");

        AppMain c = (AppMain) ctx.getBean("appMain");
        Demo um = new Demo();
        um.setAge(15);
        um.setName("zeghaun");
        um.setRemark("zeghaun");
        c.add(um);

        c.delete(11146);

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