package com.smartgeek.component.flow.annotation.node;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:38
 * @description:
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Node
public @interface ProcessNode {

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
            attribute = "enableNodeTx"
    )
    boolean enableNodeTx() default true;

    String desc() default "";

    @AliasFor(
            annotation = Node.class,
            attribute = "nextNodeRoute"
    )
    NextNodeRoute[] nextNodeRoute();


}
