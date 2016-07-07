package com.spring.repository;

import com.spring.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.annotation.Resource;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */
@Resource
public interface DemoRepository extends JpaRepository<DemoEntity, String> {
    
    DemoEntity findById(int id);
}
