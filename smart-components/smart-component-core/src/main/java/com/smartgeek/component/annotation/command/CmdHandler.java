package com.smartgeek.component.annotation.command;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/11/27 15:47
 * @description:
 */
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Component
public @interface CmdHandler {
}
