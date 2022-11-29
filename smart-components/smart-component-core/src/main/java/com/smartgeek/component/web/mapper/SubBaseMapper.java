package com.smartgeek.component.web.mapper;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubBaseEntity;

/**
 * 数据层 主子基类通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <P>  Po
 * @param <SQ> SubQuery
 * @param <SD> SubEntity
 * @param <SP> SubPo
 * @author xueyi
 */
public interface SubBaseMapper<Q extends P, D extends P, P extends SubBaseEntity<SD>, SQ extends SP, SD extends SP, SP extends BaseEntity> extends BaseMapper<Q, D, P> {
}
