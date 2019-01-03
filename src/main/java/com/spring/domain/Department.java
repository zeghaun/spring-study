package com.spring.domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2017/2/22
 */
@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
