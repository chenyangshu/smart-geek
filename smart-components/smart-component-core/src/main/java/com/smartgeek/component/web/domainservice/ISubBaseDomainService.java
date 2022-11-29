package com.smartgeek.component.web.domainservice;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubBaseEntity;

/**
 * 服务层 主子基类通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <SQ> SubQuery
 * @param <SD> SubEntity
 * @author xueyi
 */
public interface ISubBaseDomainService<Q extends SubBaseEntity<SD>, D extends SubBaseEntity<SD>, SQ extends BaseEntity, SD extends BaseEntity> extends IBaseDomainService<Q, D>, ISubDomainService<Q, D, SQ, SD> {
}
