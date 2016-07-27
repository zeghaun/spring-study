package com.spring.repository;

import com.spring.entity.DemoEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */

public interface DemoRepository extends JpaRepository<DemoEntity, String> {

    DemoEntity findById(int id);

    //    @Modifying
//    @Query(value = "update demo set age=?2 where id=?1")
//    int update(int id, int age);
    long count();

    int removeByName(String value);

    @Query(value = "SELECT new com.spring.entity.DemoEntity(d.id,d.name,d.age,d.remark) FROM DemoEntity d")
    List<DemoEntity> getDemoEntityList(Pageable pageable);

    @Query(value = "SELECT d from DemoEntity d LEFT JOIN fetch d.hibernateEntity where d.id=30")
    DemoEntity getByJoin();
}
