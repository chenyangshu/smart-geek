package com.smartgeek.component.flow.annotation.node;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:37
 * @description:
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Node(
        autoExecute = false
)
public @interface EndNode {

    @AliasFor(
            annotation = Node.class,
            attribute = "name"
    )
    String name() default "";
}
