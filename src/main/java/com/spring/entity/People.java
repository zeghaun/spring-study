package com.spring.entity;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/12/21.
 */

public class People implements Serializable {

    @DecimalMax(value = "18", message = "not yu 18")
    @DecimalMin(value = "1", message = "dayu 1")
    private Integer age;

    @NotBlank(message = "name is not blank")
    private String name;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
