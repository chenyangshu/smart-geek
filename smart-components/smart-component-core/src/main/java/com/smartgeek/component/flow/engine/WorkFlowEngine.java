package com.smartgeek.component.flow.engine;

import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.work.WorkContext;

/**
 * @author cys
 * @date 2022/11/15 9:32
 * @description:
 */
public interface WorkFlowEngine {
    <T> WorkContext<T> execute(String flowName, T inputData);

    <T> WorkContext<T> execute(String flowName, WorkContext<T> flowHandleContext);


}
