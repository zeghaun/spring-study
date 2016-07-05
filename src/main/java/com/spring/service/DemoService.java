package com.spring.service;

import com.spring.component.JdbcFactory;
import com.spring.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@Service
public class DemoService {
    @Autowired
    JdbcFactory jdbcFactory;

    public Object getList() {
        JdbcTemplate jdbcTemplate = jdbcFactory.getInstance();
        DemoDao demoDao = new DemoDao(jdbcTemplate);
        return demoDao.query("");
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

}
