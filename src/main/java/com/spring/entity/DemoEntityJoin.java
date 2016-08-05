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
public class DemoEntityJoin implements Serializable {

    private static final long serialVersionUID = 3983966738189756001L;
    //hibernate 要特别加@Id 搞不懂为啥
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude
    protected int id;

    protected String name;
    protected int age;
    protected String remark;


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

