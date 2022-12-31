package com.smartgeek.bizwork.common.starter.security.base.extension;

import com.smartgeek.bizwork.common.starter.security.base.BaseJwtUser;

public interface UserContextAware {

  /**
   * 处理token
    * @param token
   * @return
   */
  BaseJwtUser processToken(String token);

}