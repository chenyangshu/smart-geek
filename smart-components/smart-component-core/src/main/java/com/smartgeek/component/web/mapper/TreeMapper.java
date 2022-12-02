package com.smartgeek.component.web.mapper;

import com.smartgeek.component.web.model.base.TreeEntity;

/**
 * 数据层 树型通用数据处理
 *
 * @param <Q> Query
 * @param <D> Entity
 * @param <P> Po
 * @author cys
 */
public interface TreeMapper<Q extends P, D extends P, P extends TreeEntity<D>> extends BaseMapper<Q, D, P> {
}
