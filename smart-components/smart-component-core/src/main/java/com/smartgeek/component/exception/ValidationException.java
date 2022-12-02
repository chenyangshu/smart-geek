package com.smartgeek.component.exception;


import com.smartgeek.component.validate.ValidateResult;
import lombok.Getter;

import java.util.List;

/**
 * @author cys
 */
public class ValidationException extends RuntimeException {
  @Getter
  private List<ValidateResult> result;
  public ValidationException(List<ValidateResult> list){
    super();
    this.result = list;
  }
}
