package com.smartgeek.component.web.mapper;

import com.smartgeek.component.web.model.base.BaseEntity;

/**
 * 数据层 基类通用数据处理
 *
 * @param <Q> Query
 * @param <D> Entity
 * @param <P> Po
 * @author cys
 */
public interface BaseMapper<Q extends P, D extends P, P extends BaseEntity> extends BasicMapper<P> {
}
