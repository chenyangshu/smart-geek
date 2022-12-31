package com.smartgeek.bizwork.common.starter.security.config;

import com.google.common.collect.Lists;
import com.smartgeek.bizwork.common.core.annotation.FieldDesc;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "op.security.urls")
public class SecurityCommonProperties {

  @FieldDesc(name = "不需要权限的链接地址集合")
  private List<String> unAuthUrls = Lists.newArrayList();
}