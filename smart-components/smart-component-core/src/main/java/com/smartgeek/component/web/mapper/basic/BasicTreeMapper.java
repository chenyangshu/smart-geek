package com.smartgeek.component.web.mapper.basic;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.smartgeek.component.web.model.base.TreeEntity;

/**
 * 数据层 树型基类数据处理
 * 仅用于基类调用 禁止被继承使用
 *
 * @author cys
 */
public interface BasicTreeMapper<D> extends BaseMapper<TreeEntity<D>> {
}
