package com.spring.main;

import com.spring.common.utils.JsonUtil;
import com.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.Date;
import java.util.LinkedList;
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
        Pattern pattern = Pattern.compile("^[1-9][0-9]{11}$");
        System.out.println(pattern.matcher("000100000000").matches());
        Date date = new Date();
        System.out.println(date.toString());



        List<Demo> list = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            Demo demo = new Demo();
            demo.setAge(i);
            demo.setId(i * i * 10);
            list.add(demo);
        }
        log(list.size());
        log(JsonUtil.toJson(list));
    }

    public void test() {
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

    private static void log(double str) {
        System.out.println(str);
    }

    private static void log(int str) {
        System.out.println(str);
    }


}