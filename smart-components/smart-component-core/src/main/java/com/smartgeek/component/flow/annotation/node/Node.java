package com.smartgeek.component.flow.annotation.node;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:37
 * @description:
 */
@Documented
@Target({ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Node {

    String name() default "";

    String handler() default "";

    boolean autoExecute() default true;

    NextNodeRoute[] nextNodeRoute() default {};
}
