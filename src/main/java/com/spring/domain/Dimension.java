package com.spring.domain;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2017/2/24
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "dimension")
public class Dimension implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "length")
    private int length;

    @Column(name = "width")
    private int width;

    public Dimension(int id, int length, int width) {
        this.id = id;
        this.length = length;
        this.width = width;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
