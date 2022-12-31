package com.smartgeek.bizwork.common.starter.security.config;

import com.smartgeek.bizwork.common.starter.security.base.extension.DummyUserContextAware;
import com.smartgeek.bizwork.common.starter.security.base.extension.UserContextAware;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfig {

  @ConditionalOnMissingBean
  @Bean
  public UserContextAware dummyUserContext(){
    return new DummyUserContextAware();
  }

}