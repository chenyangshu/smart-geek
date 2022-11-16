package com.smartgeek.component.flow.annotation.node;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:38
 * @description:
 */
@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NextNodeRoute {
    String key();

    String nodeName();
}
