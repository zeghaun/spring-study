package com.spring.service;

import com.spring.common.query.OffsetPage;
import com.spring.common.utils.JsonUtil;
import com.spring.domain.People;
import com.spring.domain.Pet;
import com.spring.entity.DemoEntity;
import com.spring.entity.HibernateEntity;
import com.spring.repository.DemoRepository;
import com.spring.repository.HibernateRepository;
import com.spring.repository.PeopleRepository;
import com.spring.repository.PetReposity;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

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


        HibernateEntity h = new HibernateEntity();
        h.setValue("1");
        hibernateRepository.save(h);

        Set<HibernateEntity> se = new HashSet<HibernateEntity>();
        se.add(h);

        DemoEntity t = new DemoEntity(98765, "uty");
        t.setAge((int) (System.currentTimeMillis() % 1000));
        t.setHibernateEntity(se);
        demoRepository.save(t);
        log();
        log();
//        DemoEntity d = demoRepository.getByJoin();
//        log(JsonUtil.toJson(d));
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
        peopleRepository.delete(1L);
        return "delete";
    }

    public Object patch() {
        People people = new People();
        people.setName("people");

        Pet dog = new Pet();
        dog.setName("dog");
        dog.setPeople(people);

        people.setPet(dog);
//        peopleRepository.save(people);
//        petReposity.save(dog);
        petReposity.delete(29L);
        return "patcj";
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
