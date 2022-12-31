package com.smartgeek.bizwork.common.abstracts.fee;

import java.math.BigDecimal;

public interface FeeItem <O>{

  /**
   * 原始金额
   * @return
   */
  BigDecimal getFeeItemOriginMoney();

  /**
   * 费用类型
   * @return
   */
  FeeItemType getFeeItemType();

  /**
   * 获取订单原始信息
   * @return
   */
  O getOrderInfo();

}