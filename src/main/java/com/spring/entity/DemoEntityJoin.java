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

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "name", referencedColumnName = "key", insertable = false, updatable = false)
    private HibernateEntity hibernateEntity;

    public HibernateEntity getHibernateEntity() {
        return hibernateEntity;
    }

    public void setHibernateEntity(HibernateEntity hibernateEntity) {
        this.hibernateEntity = hibernateEntity;
    }

    public DemoEntityJoin() {
        this.setRemark("DemoEntityJoin");
        this.setName("new save");
    }

    public DemoEntityJoin(int id, String name, String key, String value) {
        this.id = id;
        this.name = name;
        System.out.println("key:" + key + "  value:" + value);
    }
}

