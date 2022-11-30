package com.smartgeek.component.web.repository;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubBaseEntity;

/**
 * 数据封装层 主子基类通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <SQ> SubQuery
 * @param <SD> SubEntity
 * @author xueyi
 */
public interface ISubBaseRepositoryPort<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, SQ extends BaseEntity, SD extends BaseEntity> extends ISubRepositoryPort<Q, D, SQ, SD>, IBaseRepositoryPort<Q, D> {
}
