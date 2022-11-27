package com.smartgeek.component.annotation.domain;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author cys
 * @date 2022/11/27 16:03
 * @description:
 */
@Target({ElementType.TYPE})
@Component
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainService {
    String name() default "";

    String desc() default "";
}
