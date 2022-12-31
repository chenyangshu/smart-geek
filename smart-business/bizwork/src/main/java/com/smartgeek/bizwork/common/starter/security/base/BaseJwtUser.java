package com.smartgeek.bizwork.common.starter.security.base;

import com.smartgeek.bizwork.common.core.annotation.FieldDesc;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

@Data
public abstract class BaseJwtUser implements Serializable {

  @FieldDesc(name = "用户Id")
  private Long userId;

  @FieldDesc(name = "用户名")
  private String username;

  @FieldDesc(name = "额外信息")
  private Map<String,String> extInfo;

  @FieldDesc(name = "权限信息")
  private Collection<? extends GrantedAuthority> authorities;
}