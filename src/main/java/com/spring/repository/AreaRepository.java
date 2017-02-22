package com.spring.repository;

import com.spring.domain.Area;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2017/2/14
 */
@Repository
public interface AreaRepository extends JpaRepository<Area, Integer> {
}
