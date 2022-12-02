package com.smartgeek.component.web.converter;

import com.smartgeek.component.web.model.base.TreeEntity;
import org.mapstruct.Mapping;

import java.util.Collection;
import java.util.List;

/**
 * Tree 基类 对象映射器
 *
 * @param <Q> Query
 * @param <D> Entity
 * @param <P> Po
 * @author cys
 */
public interface TreeConverter<Q extends P, D extends P, P extends TreeEntity<D>> extends BaseConverter<Q, D, P> {

    @Mapping(target = "children", ignore = true)
    D mapperEntity(P po);

    @Mapping(target = "children", ignore = true)
    List<D> mapperEntity(Collection<P> poList);

    @Mapping(target = "children", ignore = true)
    P mapperPo(D po);

    @Mapping(target = "children", ignore = true)
    List<P> mapperPo(Collection<D> poList);
}
