package com.smartgeek.component.web.repository.impl.handle;

import com.smartgeek.component.web.converter.BaseConverter;
import com.smartgeek.component.web.mapper.TreeMapper;
import com.smartgeek.component.web.model.base.TreeEntity;
import com.smartgeek.component.web.repository.impl.BaseRepositoryAdapter;

/**
 * 数据封装层处理 操作方法 树型通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <P>  Po
 * @param <PM> PoMapper
 * @author cys
 */
public class TreeHandleRepositoryAdapter<Q extends P, D extends P, P extends TreeEntity<D>, PM extends TreeMapper<Q, D, P>, CT extends BaseConverter<Q, D, P>> extends BaseRepositoryAdapter<Q, D, P, PM, CT> {
}
