package com.spring.interceptor;


import org.hibernate.EmptyInterceptor;

/**
 * 表映射拦截器
 */
public class TableMapperInterceptor extends EmptyInterceptor {
    TableMapperInterceptor() {
        System.out.println("table interceptor:  TableMapperInterceptor");
    }

    @Override
    public String onPrepareStatement(String sql) {
        System.out.println("table interceptor:" + sql);

        return sql;
    }
}
