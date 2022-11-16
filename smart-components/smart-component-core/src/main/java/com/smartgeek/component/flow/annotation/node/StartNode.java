package com.smartgeek.component.flow.annotation.node;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:39
 * @description:
 */

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Node(
        enableNodeTx = true
)
public @interface StartNode {
    @AliasFor(
            annotation = Node.class,
            attribute = "name"
    )
    String name() default "";

    @AliasFor(
            annotation = Node.class,
            attribute = "handler"
    )
    String handler() default "";

    @AliasFor(
            annotation = Node.class,
            attribute = "nextNodeRoute"
    )
    NextNodeRoute[] nextNodeRoute();


}
