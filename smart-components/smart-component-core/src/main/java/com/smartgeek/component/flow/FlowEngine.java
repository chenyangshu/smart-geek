package com.smartgeek.component.flow;

import com.smartgeek.component.flow.engine.FlowHandleContext;

/**
 * @author cys
 */
public interface FlowEngine {
    <T> FlowHandleContext<T> start(String flowName, T inputData);

    <T> FlowHandleContext<T> start(String flowName, FlowHandleContext<T> flowHandleContext, String nodeName);
}
