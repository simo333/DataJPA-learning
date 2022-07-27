package com.simo333.datajpalearning.service;

import java.util.List;

public interface ServicePattern<T> {
    T add(T toAdd);
    List<T> getAll();
    T getOne(Long id);
    void delete(Long id);
    T edit(Long id, T t);

}
