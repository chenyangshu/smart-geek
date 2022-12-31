package com.smartgeek.bizwork.common.abstracts.filters;

import com.smartgeek.bizwork.common.abstracts.model.OrderContext;

public interface OrderFilterChain<T extends OrderContext> {


  /**
   * 订单上送支付处理流程
   * @param context
   */
  void handle(T context);

  /**
   * 开启下一个鉴权
   * @param ctx
   */
  void fireNext(T ctx);

}