package com.spring.service;

import com.spring.component.JdbcFactory;
import com.spring.dao.DemoDao;
import com.spring.entity.DemoEntity;
import com.spring.entity.HibernateEntity;
import com.spring.repository.DemoRepository;
import com.spring.repository.HibernateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/6/26
 */
@Service
public class DemoService {
    @Autowired
    JdbcFactory jdbcFactory;

    @Resource
    private HibernateRepository hibernateRepository;

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
        JdbcTemplate jdbcTemplate = jdbcFactory.getInstance();
        DemoDao demoDao = new DemoDao(jdbcTemplate);
        demoDao.insert(demoEntity);

        demoEntity.setAge(-1);
        demoRepository.save(demoEntity);

        HibernateEntity hibernateEntity = new HibernateEntity();
        hibernateEntity.setId(System.currentTimeMillis() / 10 ^ 5);
        hibernateEntity.setKey("zeg" + System.currentTimeMillis());
        hibernateEntity.setValue("value");

        hibernateRepository.save(hibernateEntity);

        return hibernateRepository.save(hibernateEntity);
    }

}
