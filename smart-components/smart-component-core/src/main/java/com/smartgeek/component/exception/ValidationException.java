package com.smartgeek.component.exception;


import com.smartgeek.component.validator.ValidateResult;
import lombok.Getter;

import java.util.List;

/**
 * @author gim
 */
public class ValidationException extends RuntimeException {
  @Getter
  private List<ValidateResult> result;
  public ValidationException(List<ValidateResult> list){
    super();
    this.result = list;
  }
}
