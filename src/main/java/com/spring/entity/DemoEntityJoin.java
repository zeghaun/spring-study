package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/5
 */
@Entity
@Table(name = "demo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoEntityJoin extends DemoEntity implements Serializable {

    private static final long serialVersionUID = 3983966738189756001L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "key", insertable = false, updatable = false)
    private HibernateEntity hibernateEntity;

    public HibernateEntity getHibernateEntity() {
        return hibernateEntity;
    }

    public void setHibernateEntity(HibernateEntity hibernateEntity) {
        this.hibernateEntity = hibernateEntity;
    }
}

