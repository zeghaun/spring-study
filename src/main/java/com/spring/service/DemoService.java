package com.spring.service;

import com.spring.common.query.OffsetPage;
import com.spring.common.utils.JsonUtil;
import com.spring.domain.People;
import com.spring.domain.Pet;
import com.spring.entity.DemoEntity;
import com.spring.repository.DemoRepository;
import com.spring.repository.HibernateRepository;
import com.spring.repository.PeopleRepository;
import com.spring.repository.PetReposity;
import org.springframework.data.domain.Pageable;
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
    @Resource
    private DemoRepository demoRepository;

    @Resource
    private HibernateRepository hibernateRepository;

    @Resource
    private PeopleRepository peopleRepository;

    @Resource
    private PetReposity petReposity;

    public Object getList(int offset, int limit) {
        Pageable pageable = OffsetPage.createPage(offset, limit);
//        return d
//        demoRepository.save(new DemoEntity(1001, "zeghaun"));

//        HibernateEntity h = new HibernateEntity();
//        h.setDemoEntity(new DemoEntity(1101, "zeghaun"));
//        h.setKey("enti mysql");
//        hibernateRepository.save(h);
        log();
        log();
        DemoEntity d = demoRepository.getByJoin();
        log(JsonUtil.toJson(d));
        log("doing left join ....");
        log();
        log();
        DemoEntity dd = demoRepository.findFirstByName("new save");
        log(JsonUtil.toJson(dd));
        log("原生 ....");
        log();
        log();
        DemoEntity ddd = demoRepository.findFirstByName("key");
        log(JsonUtil.toJson(ddd));
        log("原生 ....");
        return "";
    }

    public Object delete() {
        return "delete";
    }

    public Object patch() {
        People people = new People();
        people.setName("people");


        Pet dog = new Pet();
        dog.setName("tomcat" + System.currentTimeMillis() % 1000);
        petReposity.save(dog);

        people.setPet(dog);
        peopleRepository.save(people);

        return "patch ";
    }

    public Object post(DemoEntity demoEntity) {
        demoEntity.setRemark("zeghaun post");
        demoRepository.save(demoEntity);
        return demoEntity;
    }

    private void log(String str) {
        System.out.println(str);
    }

    private void log() {
        System.out.println();
    }
}
