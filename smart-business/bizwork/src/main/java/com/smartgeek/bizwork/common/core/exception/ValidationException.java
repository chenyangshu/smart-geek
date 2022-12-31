package com.smartgeek.bizwork.common.core.exception;

import com.smartgeek.bizwork.common.core.model.ValidateResult;
import lombok.Getter;

import java.util.List;

public class ValidationException extends RuntimeException {
    @Getter
    private List<ValidateResult> result;
    public ValidationException(List<ValidateResult> list){
        super();
        this.result = list;
    }
}
