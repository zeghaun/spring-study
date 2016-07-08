package com.spring.service;

import com.spring.common.utils.JsonUtil;
import com.spring.component.JdbcFactory;
import com.spring.dao.DemoDao;
import com.spring.entity.DemoEntity;
import com.spring.main.Demo;
import com.spring.repository.DemoRepository;
import com.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@Service
@Transactional
public class DemoService {
    @Autowired(required = false)
    JdbcFactory jdbcFactory;


    @Resource
    private DemoRepository demoRepository;

    @Resource
    private TestRepository testRepository;


    public Object getList() {
        JdbcTemplate jdbcTemplate = jdbcFactory.getInstance();
        DemoDao demoDao = new DemoDao(jdbcTemplate);
        return demoDao.query();
    }

    public Object delete() {
        JdbcTemplate jdbcTemplate = jdbcFactory.getInstance();
        DemoDao demoDao = new DemoDao(jdbcTemplate);

        return demoDao.delete("");
    }

    public Object update() {
        JdbcTemplate jdbcTemplate = jdbcFactory.getInstance();
        DemoDao demoDao = new DemoDao(jdbcTemplate);

        return demoDao.update();
    }

    public Object post(DemoEntity demoEntity) {
        log("-------------------------");
        DemoEntity demo = demoRepository.findById(2);
        log(JsonUtil.toJson(demo));
        log("**************************");
        log();


        log("-------------------------");
        Demo um = new Demo();
        um.setAge(1);
        um.setName("zeghaun");
        um.setRemark("zeghaun");
        Demo um1 = testRepository.save(um);

        log(JsonUtil.toJson(um1));

        testRepository.deleteById(4);
        log("**************************");
        log();
        return demo;
    }

    private void log(String str) {
        System.out.println(str);
    }

    private void log() {
        System.out.println();
    }
}
