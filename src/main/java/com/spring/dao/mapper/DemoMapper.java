package com.spring.dao.mapper;

import com.spring.entity.DemoEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/5
 */
public class DemoMapper implements RowMapper<DemoEntity> {
    @Override
    public DemoEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
        DemoEntity model = new DemoEntity();

        model.setName(rs.getString("name"));
        model.setAge(rs.getInt("age"));
        model.setRemark(rs.getString("remark"));
        return model;
    }
}
