package com.spring.repository;

import com.spring.entity.DemoEntityJoin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/5
 */
@Repository
public interface DemoEntityJoinRepository extends JpaRepository<DemoEntityJoin, Integer> {

    DemoEntityJoin findFirstByName(String name);

    //
    @Query(value = "SELECT new com.spring.entity.DemoEntityJoin(d.id,d.name,t.key,t.value) " +
            "from DemoEntityJoin d " +
            "LEFT JOIN d.hibernateEntity t " +
            "where d.id=?1")
    DemoEntityJoin getByJoin(int id);
}