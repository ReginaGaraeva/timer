package com.windmill.timer.db;

import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T> implements Repository<T> {
    private List<T> objects = new ArrayList<>();

    @Override
    public void save(T obj) {
        objects.add(obj);
    }
}
