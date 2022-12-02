package com.smartgeek.component.flow.engine;

import com.smartgeek.component.flow.FlowEngine;
import com.smartgeek.component.flow.exception.ExceptionUtil;
import com.smartgeek.component.flow.flow.FlowExecutor;
import com.smartgeek.component.flow.flow.FlowsHub;
import org.springframework.util.ClassUtils;

/**
 * @author cys
 * @date 2022/9/21 10:56
 * @description:
 */
public class SmartFlowEngine implements FlowEngine {

    private FlowsHub flowsHub;

    public SmartFlowEngine(FlowsHub flowsHub) {
        this.flowsHub = flowsHub;
    }


    public <T> FlowHandleContext<T> start(String flowName, T inputData) {
        return this.start(flowName, new FlowHandleContext(inputData), (String)null);
    }

    public <T> FlowHandleContext<T> start(String flow, FlowHandleContext<T> flowHandleContext, String nodeName) {
        this.checkInputFlowData(flowHandleContext, flow, nodeName);
        this.executeFlow(flow, flowHandleContext, nodeName);
        return flowHandleContext;
    }


    private void checkInputFlowData(FlowHandleContext context, String flowName, String nodeName) {
        if (context == null) {
            throw new IllegalStateException("流程" + flowName + "入参context不能为空");
        } else if (context.getInputData() == null) {
            throw new IllegalStateException("流程" + flowName + "入参inputData不能为空");
        } else {
            FlowExecutor flowExecutor = this.flowsHub.getRequiredFlowExecutor(flowName);
            Object target = context.getInputData();
            if (!flowExecutor.getClassOfTarget().isAssignableFrom(target.getClass())) {
                throw new IllegalArgumentException(String.format("传入的流程入参的类型[%s]和流程%s期望的类型[%s]不匹配", ClassUtils.getShortName(target.getClass()), flowExecutor.getFlowName(), ClassUtils.getShortName(flowExecutor.getClassOfTarget())));
            } else if (nodeName != null && !flowExecutor.containsNode(nodeName)) {
                throw new IllegalStateException("流程" + flowName + "不存在节点" + nodeName);
            }
        }
    }


    private void executeFlow(String flowName, FlowHandleContext flowHandleContext, String nodeName) {
        try {
            FlowExecutor flowExecutor = this.flowsHub.getRequiredFlowExecutor(flowName);
            if (nodeName == null) {
                flowExecutor.execute(flowHandleContext);
            } else {
                flowExecutor.execute(flowHandleContext, nodeName);
            }
        } catch (Throwable e) {
            ExceptionUtil.rethrow(e);

        }

    }

}
