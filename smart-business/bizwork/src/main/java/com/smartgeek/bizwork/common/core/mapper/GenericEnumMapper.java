package com.smartgeek.bizwork.common.core.mapper;

import com.smartgeek.bizwork.common.core.constants.ValidStatus;

public class GenericEnumMapper {

    public Integer asInteger(ValidStatus status) {
        return status.getCode();
    }

    public ValidStatus asValidStatus(Integer code) {
        return ValidStatus.of(code).orElse(ValidStatus.INVALID);
    }
}
