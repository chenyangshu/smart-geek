package com.smartgeek.component.web.repository;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubTreeEntity;

/**
 * 数据封装层 主子树型通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <SQ> SubQuery
 * @param <SD> SubEntity
 * @author xueyi
 */
public interface ISubTreeRepository<Q extends SubTreeEntity<D, SD>, D extends SubTreeEntity<D, SD>, SQ extends BaseEntity, SD extends BaseEntity> extends ISubManager<Q, D, SQ, SD>, ITreeRepository<Q, D> {
}
