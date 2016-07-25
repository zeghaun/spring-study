/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.spring.common.validator.constraint.Even;
import com.spring.common.validator.groups.Create;
import com.spring.common.validator.groups.Modify;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Entity
@Table(name = "demo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoEntity implements Serializable {
    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;
    //hibernate 要特别加@Id 搞不懂为啥
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonInclude
    private int id;

    @NotBlank(message = "name", groups = {Create.class, Modify.class})
    @Pattern(regexp = "^[a-zA-Z]{1,10}$", message = "{evaluation.dentry_id.illegal}")
    private String name;

    @Range(min = 0, max = 150, message = "{age}", groups = {Create.class, Modify.class})
    @Even(message = "{even.age}", groups = {Create.class, Modify.class})
    private int age;

    @Length(min = 0, max = 255, message = " remark ", groups = {Create.class, Modify.class})
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