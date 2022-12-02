package com.smartgeek.component.operation;

import cn.hutool.core.collection.CollUtil;
import com.smartgeek.component.exception.ValidationException;
import com.smartgeek.component.validate.ValidateGroup;
import com.smartgeek.component.validate.ValidateResult;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


/**
 * 基本实体操作
 *
 * @author chenyangshu
 * @date 2022/09/04
 */
public class BaseEntityOperation implements EntityOperation {
    static final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

    public <T> void doValidate(T t, Class<? extends ValidateGroup> group) {
        Set<ConstraintViolation<T>> constraintViolations = validator.validate(t, group, Default.class);
        if (!CollUtil.isEmpty(constraintViolations)) {
            List<ValidateResult> results = constraintViolations.stream()
                    .map(cv -> new ValidateResult(cv.getPropertyPath().toString(), cv.getMessage()))
                    .collect(Collectors.toList());
            throw new ValidationException(results);
        }
    }

}
