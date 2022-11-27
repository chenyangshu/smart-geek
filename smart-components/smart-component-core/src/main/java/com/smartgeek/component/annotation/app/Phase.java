package com.smartgeek.component.annotation.app;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/11/27 18:40
 * @description:
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface Phase {
    String value() default "";
}

