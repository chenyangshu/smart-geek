package com.smartgeek.component.operation;

import java.util.Optional;

/**
 * @author cys
 * @date 2022/11/27 14:52
 * @description:
 */
public interface CrudPort<T, ID> {

    boolean existsById(ID id);

    Iterable<T> findAllById(Iterable<ID> ids);

    Optional<T> findById(ID id);

    void delete(T entity);

    void deleteAll(Iterable<? extends T> entities);

    void deleteById(ID id);

    <S extends T> S create(S entity);

    <S extends T> Iterable<S> create(Iterable<S> entities);

    <S extends T> S updateById(S entity);

    <S extends T> Iterable<S> updateById(Iterable<S> entities);


}
