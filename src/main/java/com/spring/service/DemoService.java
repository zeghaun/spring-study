package com.spring.service;

import com.spring.common.utils.JsonUtil;
import com.spring.component.JdbcFactory;
import com.spring.dao.DemoDao;
import com.spring.entity.DemoEntity;
import com.spring.repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@Service
public class DemoService {
    @Autowired
    JdbcFactory jdbcFactory;


    @Resource
    private DemoRepository demoRepository;

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
        demoEntity.setAge(-1);
        demoRepository.save(demoEntity);

        log("-------------------------");
        DemoEntity demo = demoRepository.findById(2);
        log(JsonUtil.toJson(demo));
        log("**************************");
        log();


        log("-------------------------");
        List<DemoEntity> list = demoRepository.removeByName("fweew");

        log(JsonUtil.toJson(list));
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
