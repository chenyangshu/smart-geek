package com.smartgeek.bizwork.common.starter.security.base;

import lombok.Data;

@Data
public class LoginSuccessResponse {

  private String token;
  private String username;
}