package com.spring.service;

import com.spring.common.query.OffsetPage;
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
        return demoRepository.getByJoin();
    }

    public Object delete() {
        return "delete";
    }

    public Object update() {
        return "update";
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
