package com.smartgeek.bizwork.common.starter.security;

import com.smartgeek.bizwork.common.starter.security.auto.SecurityConfig;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ConditionalOnProperty(prefix = "op.security", name = "enable", havingValue = "true")
public class SecurityAutoConfiguration {

  @Configuration
  @ComponentScan(value = {"com.smartgeek.bizwork.common.starter.security.base","com.smartgeek.bizwork.common.starter.security.config"})
  @Import(value = {SecurityConfig.class})
  public class AdminSecurityConfig{

  }
}