package com.smartgeek.bizwork.common.abstracts.filters.selector;

import com.smartgeek.bizwork.common.abstracts.constants.BizEnum;

public interface BizAware {

  /**
   * 获取当前业务编码
   * @return
   */
  BizEnum getBizCode();
}