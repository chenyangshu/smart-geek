package com.smartgeek.component.annotation.domain;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/11/27 18:43
 * @description:
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface Entity {
}
