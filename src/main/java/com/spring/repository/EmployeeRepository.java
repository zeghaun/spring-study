package com.spring.repository;

import com.spring.domain.Department;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/8
 */
public interface EmployeeRepository extends JpaRepository<Department, Integer> {


}