package com.smartgeek.component.flow.annotation.processor;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:39
 * @description:
 */

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Processor {
    String name() default "";
}
