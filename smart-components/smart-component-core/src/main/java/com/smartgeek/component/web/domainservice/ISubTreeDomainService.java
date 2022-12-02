package com.smartgeek.component.web.domainservice;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubTreeEntity;

/**
 * 服务层 主子树型通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <SQ> SubQuery
 * @param <SD> SubEntity
 * @author cys
 */
public interface ISubTreeDomainService<Q extends SubTreeEntity<D, SD>, D extends SubTreeEntity<D, SD>, SQ extends BaseEntity, SD extends BaseEntity> extends ITreeDomainService<Q, D>, ISubDomainService<Q, D, SQ, SD> {
}
