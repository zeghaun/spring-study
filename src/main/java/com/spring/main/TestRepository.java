package com.spring.main;

import com.spring.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/8
 */
@Repository
public interface TestRepository extends JpaRepository<Demo, Long>, JpaSpecificationExecutor<Demo> {

    @Modifying
//@Query("delete from DemoEntity s where s.id in ?1")
    //上下两者等价，上面是jsql  下面是原生
    @Query(value = "delete from demo where id = ?1", nativeQuery = true)
    void deleteById(int id);
}