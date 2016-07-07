package com.spring.repository;

import com.spring.entity.DemoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */
@Resource
@Transactional
public interface DemoRepository extends CrudRepository<DemoEntity, String> {

    DemoEntity findById(int id);

    //    @Modifying
//    @Query(value = "update demo set age=?2 where id=?1")
//    int update(int id, int age);
    long count();


    List<DemoEntity> removeByName(String value);
}
