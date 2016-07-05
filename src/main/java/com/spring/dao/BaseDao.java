package com.spring.dao;

import java.util.List;

public abstract class BaseDao<T> {

    public abstract List<T> query(String condition, Object... params);

    public abstract long getCount(String condition, Object... params);

    public abstract long insert(final T model);

    public abstract int update(String condition, final Object[] params, final T model);

    public abstract int delete(String condition, final Object... params);
}