package com.spring.repository;

import com.spring.entity.HibernateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */
@Repository
public interface HibernateRepository extends JpaRepository<HibernateEntity, Integer> {

    HibernateEntity findById(int id);

//    @Modifying
//    @Query(value = "DELETE FROM HibernateEntity h WHERE h.value=:value")
//    int deleteByValue(@Param("value") String value);
}
