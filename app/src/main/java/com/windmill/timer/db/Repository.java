package com.windmill.timer.db;

public interface Repository<T> {
    public void save(T obj);
}
