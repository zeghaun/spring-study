package com.spring.repository;

import com.spring.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/10
 */
public interface PetReposity extends JpaRepository<Pet, Long> {
    Pet findByName(String name);
}
