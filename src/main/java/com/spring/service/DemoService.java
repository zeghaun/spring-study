package com.spring.service;

import com.spring.common.query.OffsetPage;
import com.spring.common.utils.JsonUtil;
import com.spring.component.JdbcFactory;
import com.spring.entity.DemoEntity;
import com.spring.repository.DemoRepository;
import com.spring.repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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


    public Object getList(int offset, int limit) {
        Pageable pageable = OffsetPage.createPage(offset, limit);
//        return demoRepository.getDemoEntityList(pageable);

        log();
        log();
        DemoEntity d = demoRepository.getByJoin();
        log(JsonUtil.toJson(d));
        log("doing left join ....");
        log();
        log();
        DemoEntity dd = demoRepository.findByName("hibernate");
        log(JsonUtil.toJson(dd));
        log("原生 ....");
        log();
        log();
        DemoEntity ddd = demoRepository.findByName("hibernate");
        log(JsonUtil.toJson(ddd));
        log("原生 ....");
        return "";
    }

    public Object delete() {
        return "delete";
    }

    public Object patch() {
        return demoRepository.findByName("hibernate");
    }

    public Object post(DemoEntity demoEntity) {
        demoEntity.setRemark("zeghaun post");
        demoRepository.save(demoEntity);
        return demoEntity;
    }

    private void demoJDBC() {
        JdbcTemplate jdbcTemplate = jdbcFactory.getInstance();

    }

    private void log(String str) {
        System.out.println(str);
    }

    private void log() {
        System.out.println();
    }
}
