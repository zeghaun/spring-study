package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/10
 */
@Entity
@Table(name = "user")
public class User implements Serializable {


    private static final long serialVersionUID = 6177417450707400228L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String password;

    /*
     * cascade：为级联操作，里面有级联保存，级联删除等，all为所有
     * fetch：加载类型，有lazy和eager二种，
     *   eager为急加载，意为立即加载，在类加载时就加载，lazy为慢加载，第一次调用的时候再加载，由于数据量太大，onetomany一般为lazy
     * mappedBy：这个为manytoone中的对象名，这个不要变哦
     * Set<role>：这个类型有两种，一种为list另一种为set
     *
     *
     */

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnore
    private DemoEntity demoEntity;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
