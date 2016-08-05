package com.spring.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/5
 */
@Entity
@Table(name = "demo")
@DiscriminatorValue("null")
public class DemoEntityJoin extends DemoEntity implements Serializable {

    private static final long serialVersionUID = 3983966738189756001L;

    public DemoEntityJoin() {
        this.setRemark("DemoEntityJoin");
        this.setName("new save");
    }

    public DemoEntityJoin(int id, String name, int age, String remark, HibernateEntity hibernateEntity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remark = remark;
        this.hibernateEntity = hibernateEntity;
    }

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "name", referencedColumnName = "key", insertable = false, updatable = false)
    private HibernateEntity hibernateEntity;

    public HibernateEntity getHibernateEntity() {
        return hibernateEntity;
    }

    public void setHibernateEntity(HibernateEntity hibernateEntity) {
        this.hibernateEntity = hibernateEntity;
    }
}

