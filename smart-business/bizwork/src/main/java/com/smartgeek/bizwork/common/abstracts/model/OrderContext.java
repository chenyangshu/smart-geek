package com.smartgeek.bizwork.common.abstracts.model;

import com.smartgeek.bizwork.common.abstracts.constants.BizEnum;
import com.smartgeek.bizwork.common.abstracts.filters.selector.FilterSelector;

public interface OrderContext{

  /**
   * 获取业务编码
   * @return
   */
  BizEnum getBizCode();

  /**
   * 获取过滤器选择器
   * @return
   */
  FilterSelector getFilterSelector();

  /**
   * 是否继续链
   * @return
   */
  boolean continueChain();



}