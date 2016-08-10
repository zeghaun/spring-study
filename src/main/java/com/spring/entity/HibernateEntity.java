package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/7
 */
@Entity
@Table(name = "hibernate")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HibernateEntity implements Serializable {
    private static final long serialVersionUID = -1369937499218926305L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String key;

    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "demo_id")
    @JsonIgnore
    private DemoEntity demoEntity;

    public HibernateEntity(){

    }
    public DemoEntity getDemoEntity() {
        return demoEntity;
    }

    public void setDemoEntity(DemoEntity demoEntity) {
        this.demoEntity = demoEntity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
