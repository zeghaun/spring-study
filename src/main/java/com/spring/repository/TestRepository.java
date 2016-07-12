package com.spring.repository;

import com.spring.main.Demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/8
 */
public interface TestRepository extends JpaRepository<Demo, Long> {

    @Modifying
    @Query("delete from Demo s where s.id in :id")
        //上下两者等价，上面是jsql  下面是原生
//    @Query(value = "delete from demo where id = ?1", nativeQuery = true)
    void deleteById(@Param("id") int id);
}