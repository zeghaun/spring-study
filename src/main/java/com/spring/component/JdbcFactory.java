/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.component;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class JdbcFactory {

    public static long getDbIndex(long id) {
        return id % 10;
    }

    public final JdbcTemplate getGlobalJTAInstance() {
        JdbcTemplate jdbcTemplate = null;
        jdbcTemplate = (JdbcTemplate) BeanFactory.getBean("jtaJdbcTemplate_global");
        if (jdbcTemplate == null) {
            throw new RuntimeException("JdbcTemplate is null....");
        }
        return jdbcTemplate;
    }

    public final JdbcTemplate getJTAInstanceByDb(long id) {
        if (id < 0) {
            id = 0L;
        }
        JdbcTemplate jdbcTemplate = null;
        jdbcTemplate = (JdbcTemplate) BeanFactory.getBean("jtaJdbcTemplate_" + getDbIndex(id));
        if (jdbcTemplate == null) {
            throw new RuntimeException("JdbcTemplate is null....");
        }

        return jdbcTemplate;
    }

    /**
     * 默认的
     *
     * @return
     */
    public JdbcTemplate getInstance() {
        return getGlobalJTAInstance();
    }
}
