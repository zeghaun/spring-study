/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.entity;

import com.spring.common.validator.Create;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import java.io.Serializable;


public class DemoEntity implements Serializable {
    /**
     * Default serial version ID.
     */
    private static final long serialVersionUID = 1L;

    @Length(min = 1, max = 2, message = "${fail}")
    @NotBlank(message = "name", groups = {Create.class})
    private String name;


    private int age;

}