package com.spring.repository;

import com.spring.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
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

    @Modifying
    @Query(value = "DELETE FROM demo WHERE name=?1", nativeQuery = true)
    int removeByName(String value);
}
