package com.spring.main;

import com.spring.common.utils.JsonUtil;
import com.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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

        List<Long> list = new ArrayList<>();
        list.add(1L);
        List<Long> te = new ArrayList<>();
        te.add(2L);
        list.addAll(te);

        System.out.println(JsonUtil.toJson(new HashSet<Long>(null)));
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