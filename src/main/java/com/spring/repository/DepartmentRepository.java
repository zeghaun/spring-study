package com.spring.repository;

import com.spring.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2017/2/22
 */
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
