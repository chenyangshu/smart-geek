package com.smartgeek.component.flow.processor;


import com.smartgeek.component.flow.engine.FlowHandleContext;

/**
 * 节点处理器
 *
 * @author treeyschen
 * @date 2022/09/21
 */
public interface NodeProcessor<T, R> {

    R execute(FlowHandleContext<T> flowHandleContext);


}
