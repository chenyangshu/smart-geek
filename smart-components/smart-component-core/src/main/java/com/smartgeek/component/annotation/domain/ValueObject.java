package com.smartgeek.component.annotation.domain;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/11/27 18:45
 * @description:
 */
@Documented
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValueObject {
    Class root() default DefaultRoot.class;
}
