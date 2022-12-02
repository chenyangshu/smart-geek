package com.smartgeek.component.web.converter;

import com.smartgeek.component.web.model.base.BaseEntity;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

/**
 * SubBase 基类 对象映射器
 *
 * @param <Q> Query
 * @param <D> Entity
 * @param <P> Po
 * @author cys
 */
public interface SubBaseConverter<Q extends P, D extends P, P extends BaseEntity> extends BaseConverter<Q, D, P> {

    @Mapping(target = "subList", ignore = true)
    D mapperEntity(P po);

    @Mapping(target = "subList", ignore = true)
    List<D> mapperEntity(Collection<P> poList);

    @Mapping(target = "subList", ignore = true)
    P mapperPo(D po);

    @Mapping(target = "subList", ignore = true)
    List<P> mapperPo(Collection<D> poList);
}
