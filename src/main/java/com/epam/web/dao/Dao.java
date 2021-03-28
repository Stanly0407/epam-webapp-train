package com.epam.web.dao;


import com.epam.web.entities.Entity;
import com.epam.web.exceptions.DaoException;

import java.util.List;
import java.util.Optional;

public interface Dao <T extends Entity> {

    Optional<T> getById(Long id);

    List<T> getAll () throws DaoException;

    void save(T entity);

    void removeById(Long id);

    // someone else...
    // tablename -> constructor -> getAll //


}
