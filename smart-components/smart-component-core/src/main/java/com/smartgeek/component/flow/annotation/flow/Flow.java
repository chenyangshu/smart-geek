package com.smartgeek.component.flow.annotation.flow;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author cys
 * @date 2022/9/21 10:36
 * @description:
 */

@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Flow {

    /**
     * 流程名称（默认使用被注解的类名，首字母小写）
     */
    String name();
    /**
     * 是否开启流程事务（默认开启）
     */
    boolean enableFlowTx() default true;


    /**
     * 指定事务管理器的bean name
     * 用于多个数据源情况下，不指定则使用默认事务管理器
     */
    String txManager() default "";
    /**
     * 当前流程的描述
     *
     * @return
     */
    String desc();
    /**
     * 流程的唯一Id
     *
     * @return
     */
    String id() default "";

}
