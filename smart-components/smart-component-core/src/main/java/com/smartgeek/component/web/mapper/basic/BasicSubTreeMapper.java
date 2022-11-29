package com.smartgeek.component.web.mapper.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smartgeek.component.web.model.base.SubTreeEntity;

/**
 * 数据层 主子树型基类数据处理
 * 仅用于基类调用 禁止被继承使用
 *
 * @author xueyi
 */
public interface BasicSubTreeMapper<D, S> extends BaseMapper<SubTreeEntity<D, S>> {
}
