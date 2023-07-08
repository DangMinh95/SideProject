package com.example.sideproject.service;

import java.util.List;
import java.util.Optional;

public interface CrudService<T, ID> {
    List<T> getAll();

    T getEntity(ID id);

    T create(T obj);

    T update(ID id,T obj);

    void delete(Long id);
}
