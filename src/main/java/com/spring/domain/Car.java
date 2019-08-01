package com.spring.domain;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2017/2/24
 */

import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "car")
@SqlResultSetMapping(name = "carkey",
        entities = @EntityResult(entityClass = Car.class,
                fields = {
                        @FieldResult(name = "id", column = "id"),
                        @FieldResult(name = "name", column = "name"),
                        @FieldResult(name = "dimension.length", column = "length"),
                        @FieldResult(name = "dimension.width", column = "width")
                }),
        columns = {@ColumnResult(name = "area")})

@NamedNativeQuery(name = "carkey", query = "select id as id,name as name,length as length,width as width,length*width as area from Car", resultSetMapping = "carkey")
public class Car implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumns({
            @JoinColumn(name = "id", referencedColumnName = "id")
    })
    private Dimension dimension;

    public Car(int id, String name) {
        this.id = id;
        this.name = name;
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

    public Dimension getDimension() {
        return dimension;
    }

    public void setDimension(Dimension dimension) {
        this.dimension = dimension;
    }
}