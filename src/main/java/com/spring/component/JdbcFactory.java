/**
 * @copyright Copyright 1999-2015 © 99.com All rights reserved.
 * @license http://www.99.com/about
 */
package com.spring.component;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;



public final class JdbcFactory {
//    @Resource(name = "mysql_global")
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplate getInstance() {
        if (jdbcTemplate == null) {
            throw new RuntimeException("JdbcTemplate is null....");
        }
        return jdbcTemplate;
    }
}
