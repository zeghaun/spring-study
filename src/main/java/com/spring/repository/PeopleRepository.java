package com.spring.repository;

import com.spring.domain.People;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/10
 */
public interface PeopleRepository extends JpaRepository<People, Long> {
}
