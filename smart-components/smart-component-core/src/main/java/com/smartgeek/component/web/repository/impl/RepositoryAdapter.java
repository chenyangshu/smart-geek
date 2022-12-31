package com.smartgeek.component.web.repository.impl;

import cn.hutool.core.util.ObjectUtil;
import com.smartgeek.component.operation.BaseRepository;
import com.smartgeek.component.web.converter.BasicConverter;
import com.smartgeek.component.web.mapper.BasicMapper;
import com.smartgeek.component.web.model.base.BasisEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @author cys
 */
public class RepositoryAdapter<T extends BasisEntity, P extends BasisEntity, CT extends BasicConverter<T, P>, PM extends BasicMapper<P>> implements BaseRepository<T> {

    @Autowired
    private CT converter;

    @Autowired
    private PM mapper;


    @Override
    public boolean existsById(Serializable id) {
        return ObjectUtil.isNotNull(mapper.selectById(id));
    }

    @Override
    public List<T> findAllById(Collection<? extends Serializable> ids) {
        return converter.mapperEntity(mapper.selectBatchIds(ids));
    }

    @Override
    public Optional<T> findById(Serializable id) {
        return Optional.ofNullable(converter.mapperEntity(mapper.selectById(id)));
    }

    @Override
    public void delete(T entity) {
        mapper.deleteById(converter.mapperPo(entity));
    }

    @Override
    public T create(T entity) {
        P po = converter.mapperPo(entity);
        mapper.insert(converter.mapperPo(entity));
        entity.setId(po.getId());
        return entity;
    }

    @Override
    public T updateById(T entity) {
        mapper.updateById(converter.mapperPo(entity));
        return entity;
    }

    @Override
    public Collection<T> updateById(Collection<T> entities) {
        mapper.updateBatch(converter.mapperPo(entities));
        return entities;
    }
}
