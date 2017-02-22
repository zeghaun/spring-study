package com.spring.repository;

import com.spring.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2017/2/14
 */
public interface UserRepository extends JpaRepository<User, Long> {
}
