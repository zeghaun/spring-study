package com.spring.filter;


import org.hibernate.EmptyInterceptor;

/**
 * 表映射拦截器
 */
public class TableMapperInterceptor extends EmptyInterceptor {
    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("Interceptor  sql:" + sql);

        return sql;
    }
}
