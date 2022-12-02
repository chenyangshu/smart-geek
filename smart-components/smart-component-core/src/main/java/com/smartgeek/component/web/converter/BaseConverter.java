package com.smartgeek.component.web.converter;

import com.github.pagehelper.Page;
import com.smartgeek.component.web.model.base.BaseEntity;

import java.util.Collection;
import java.util.List;

/**
 * Base 基类 对象映射器
 *
 * @param <Q> Query
 * @param <D> Entity
 * @param <P> Po
 * @author cys
 */
public interface BaseConverter<Q extends P, D extends P, P extends BaseEntity> {

    /**
     * 类型转换 | 持久化对象 -> 数据传输对象
     *
     * @param po 持久化对象
     * @return entity
     */
    D mapperEntity(P po);

    /**
     * 类型转换 | 持久化对象集合 -> 数据传输对象集合
     *
     * @param poList 持久化对象集合
     * @return entityList
     */
    List<D> mapperEntity(Collection<P> poList);

    /**
     * 类型转换 | 持久化对象集合 -> 数据传输分页对象集合
     *
     * @param poList 持久化对象集合
     * @return entityList
     */
    Page<D> mapperPageEntity(Collection<P> poList);

    /**
     * 类型转换 | 数据传输对象 -> 持久化对象
     *
     * @param entity 数据传输对象
     * @return po
     */
    P mapperPo(D entity);

    /**
     * 类型转换 | 数据传输对象集合 -> 持久化对象集合
     *
     * @param entityList 数据传输对象集合
     * @return poList
     */
    List<P> mapperPo(Collection<D> entityList);

    /**
     * 类型转换 | 数据传输对象集合 -> 持久化分页对象集合
     *
     * @param entityList 数据传输对象集合
     * @return poList
     */
    Page<P> mapperPagePo(Collection<D> entityList);
}
