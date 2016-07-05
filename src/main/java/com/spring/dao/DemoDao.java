package com.spring.dao;

import com.spring.dao.mapper.DemoMapper;
import com.spring.entity.DemoEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhenghuan (zeghaun@163.com)
 * @version Created by zhenghuan on 2016/7/5
 */
public class DemoDao extends BaseDao<DemoEntity> {
    public static final String TABLE = "demo";

    private JdbcTemplate jdbcTemplate;

    public DemoDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<DemoEntity> query(String condition, Object... params) {
        final String sql = "SELECT * FROM "
                + TABLE
                + ((condition == null || condition.trim().isEmpty()) ? "" : (" WHERE " + condition));

        return jdbcTemplate.query(sql, new DemoMapper(), params);

    }

    public List<DemoEntity> query() {
        return query(null);
    }

    @Override
    public long getCount(String condition, Object... params) {
        return 0;
    }

    @Override
    public long insert(final DemoEntity model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "INSERT INTO " + TABLE + " (name,age,remark) " + " values(?,?,?)";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

                ps.setString(1, model.getName());
                ps.setInt(2, model.getAge());
                ps.setString(3, model.getRemark());
                return ps;
            }

        }, keyHolder);

        return keyHolder.getKey().intValue();
    }

    @Override
    public int update(String condition, Object[] where, DemoEntity model) {
        String sql = "update " + TABLE + " set ";
        ArrayList<Object> params = new ArrayList<Object>();

        //要更改的值
        if (model.getRemark() != null) {
            sql += " remark=? ";
            params.add(model.getRemark());
        }
        return jdbcTemplate.update(sql, params.toArray());
    }

    public int update() {
        return -1;
    }

    @Override
    public int delete(String condition, Object... params) {
        final String sql = "DELETE FROM " + TABLE + " WHERE　" + condition;
        return jdbcTemplate.update(sql, params);
    }
}
