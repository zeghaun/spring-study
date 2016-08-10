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
import java.util.Set;

@Entity
@Table(name = "demo")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DemoEntity implements Serializable {
    private static final long serialVersionUID = -4986897468519809465L;
    /**
     * Default serial version ID.
     */
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


    @OneToMany(cascade = {CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "h_id")
    private Set<HibernateEntity> hibernateEntity;

    public Set<HibernateEntity> getHibernateEntity() {
        return hibernateEntity;
    }

    public void setHibernateEntity(Set<HibernateEntity> hibernateEntity) {
        this.hibernateEntity = hibernateEntity;
    }

    public DemoEntity() {

    }

    public DemoEntity(int id, String name) {
        this.id = id;
        this.name = name;
        System.out.println("DemoEntity");
    }

    public DemoEntity(int id, String name, int ids) {
        this.id = id;
        this.name = name;
    }

    public DemoEntity(int id, String name, Set<HibernateEntity> hibernateEntity) {
        this.id = id;
        this.name = name;
        this.hibernateEntity = hibernateEntity;
        System.out.println("DemoEntity hibernateEntity33:");
    }

    public DemoEntity(int id, String name, String key, String value) {
        this.id = id;
        this.name = name;
        System.out.println();
        System.out.println("key:" + key + "  value:" + value);
    }

    public DemoEntity(int id, String name, int age, String remark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remark = remark;
    }

    public DemoEntity(int id, String name, int age, String remark, Set<HibernateEntity> hibernateEntity) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.remark = remark;
        this.hibernateEntity = hibernateEntity;
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
//
//
//@Entity
//@Table(name = "orders")
//class Order {
//
//    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY, mappedBy = "order")
//    private Collection lineItems = new HashSet<>();
//
//    @OneToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY, mappedBy = "order")
//    @JoinColumn(name = "order_id")
//    private OrderPrice salePrice;
//
//    @OneToOne(cascade = {CascadeType.REMOVE}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
//    private Customer customer;
//}
//
//@Entity
//@Table(name = "order_items")
//class LineItem {
//
//    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST,
//            CascadeType.REFRESH}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
//    private Order order;
//
//}
//
//@Entity
//@Table(name = "order_finance")
//@AttributeOverride(name = "id", column = @Column(name = "order_id"))
//class OrderPrice extends Price {
//
//    private Order order;
//
//    @OneToOne(cascade = {}, fetch = FetchType.LAZY)
//    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }
//
//}
//
//@MappedSupperclass
//@Table(name = "order_finance")
//class Price {
//    @Id
//    public Integer getId() {
//    }
//}