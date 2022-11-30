package com.smartgeek.component.operation;

import com.smartgeek.component.web.model.base.BasisEntity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author cys
 * @date 2022/11/27 14:52
 * @description:
 */
public interface IRepositoryPort<T> {

    boolean existsById(Serializable id);

    List<T> findAllById(Collection<? extends Serializable> ids);

    Optional<T> findById(Serializable id);

    void delete(T entity);

    T create(T entity);

    T updateById(T entity);

    Collection<T> updateById(Collection<T> entities);


}
