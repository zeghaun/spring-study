package com.spring.dao;

import com.spring.dao.mapper.DemoMapper;
import com.spring.entity.DemoEntity;
import org.springframework.jdbc.core.JdbcTemplate;

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

    public List<DemoEntity> query(){
        return query(null);
    }

    @Override
    public long getCount(String condition, Object... params) {
        return 0;
    }

    @Override
    public long insert(DemoEntity model) {
        return 0;
    }

    @Override
    public int update(String condition, Object[] params, DemoEntity model) {
        return 0;
    }

    @Override
    public int delete(String condition, Object... params) {
        return 0;
    }
}
