package com.spring.repository;

import com.spring.entity.DemoEntity;
import org.springframework.data.repository.CrudRepository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */
@Resource
public interface DemoRepository extends CrudRepository<DemoEntity, String> {

    DemoEntity findById(int id);

//    @Modifying
//    @Query(value = "update demo set age=?1 where id=?2", nativeQuery = true)
//    int update(int id, int age);

    long count();

    List<DemoEntity> removeByName(String name);
}
