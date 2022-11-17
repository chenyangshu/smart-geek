package com.smartgeek.component.flow.engine;

/**
 * @author cys
 * @date 2022/11/15 9:32
 * @description:
 */
public interface WorkFlowEngine {
    <T> WorkContext<T> execute(String flowName, T inputData);

    <T> WorkContext<T> execute(String flowName, WorkContext<T> flowHandleContext);


}
