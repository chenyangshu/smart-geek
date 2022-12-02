package com.smartgeek.component.web.mapper;

import com.smartgeek.component.web.model.base.BaseEntity;
import com.smartgeek.component.web.model.base.SubTreeEntity;

/**
 * 数据层 主子树型通用数据处理
 *
 * @param <Q>  Query
 * @param <D>  Entity
 * @param <P>  Po
 * @param <SQ> SubQuery
 * @param <SD> SubEntity
 * @param <SP> SubPo
 * @author cys
 */
public interface SubTreeMapper<Q extends P, D extends P, P extends SubTreeEntity<D, SD>, SQ extends SP, SD extends SP, SP extends BaseEntity> extends TreeMapper<Q, D, P> {
}
