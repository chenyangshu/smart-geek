package com.smartgeek.bizwork.common.abstracts.filters;

import com.smartgeek.bizwork.common.abstracts.model.OrderContext;

public interface OrderFilter<T extends OrderContext> {

  /**
   * 过滤逻辑封装点
   *
   * @param context
   * @param chain
   */
  void doFilter(T context, OrderFilterChain chain);


}