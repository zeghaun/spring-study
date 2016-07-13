package com.spring.interceptor;


import org.hibernate.EmptyInterceptor;
import org.springframework.stereotype.Component;

/**
 * 表映射拦截器
 */
@Component
public class TableMapperInterceptor extends EmptyInterceptor {

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("table interceptor:" + sql);

        return sql;
    }
}
