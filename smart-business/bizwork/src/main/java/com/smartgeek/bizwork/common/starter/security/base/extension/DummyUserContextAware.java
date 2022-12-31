package com.smartgeek.bizwork.common.starter.security.base.extension;

import com.smartgeek.bizwork.common.starter.security.base.BaseJwtUser;

/**
 * 没有任何信息的用户上下文
 */
public class DummyUserContextAware implements UserContextAware{

  @Override
  public BaseJwtUser processToken(String token) {
    return new DummyJwtUser();
  }
}