package com.spring.main;


import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/8
 */
@Entity
@Table(name = "demo")
public class Demo {
    /**
     * Default serial version ID.
     */
    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;
    //hibenate 要特别加@Id 搞不懂为啥
    @Id
    @GeneratedValue
    private int id;

    @NotBlank(message = "name")
    @Pattern(regexp = "^[a-zA-Z]{1,10}$", message = "{evaluation.dentry_id.illegal}")
    private String name;

    @Range(min = 0, max = 150, message = "{age}")
    private int age;

    @Length(min = 0, max = 255, message = " remark ")
    private String remark;

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
