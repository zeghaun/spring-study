package com.spring.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/8/10
 */
@Entity
@Table(name = "people")
public class People {
    @Id  //JPA注释： 主键
    @GeneratedValue(strategy = GenerationType.AUTO)   //设置 id 为自增长
    private Long id;

    private String name;

    //由于，people 是这个一对一的关系的主控方，所以，在people表中添加了一个 pet 的外键。
    //通过这个外键来维护 people和pet的一对一关系，而不是用第三张码表。这个是通过@JoinColumn注释实现的。
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "people",fetch = FetchType.EAGER) //JPA注释： 一对一 关系
//    @JoinColumn(name = "pet_fk")// 在pepole中，添加一个外键 "pet_fk"
    private List<Pet> pets = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    public void add(Pet pet) {
        if (pet != null) {
            pets.add(pet);
        }
    }
}
