package com.smartgeek.component.flow.engine;

import com.smartgeek.component.flow.exception.ExceptionUtil;
import com.smartgeek.component.flow.workflow.WorkFlowHub;
import com.smartgeek.component.flow.workflow.AbstractWorkFlow;
import lombok.AllArgsConstructor;

/**
 * @author cys
 * @date 2022/11/15 10:53
 * @description:
 */
@AllArgsConstructor
public class DefaultWorkFlowEngine implements WorkFlowEngine {

//    // 流程注册器
//    private final WorkFlowRegistrar workFlowRegistrar;


    @Override
    public <T> WorkContext<T> execute(String flowName, T inputData) {
        return this.execute(flowName, new WorkContext<>(inputData));
    }

    @Override
    public <T> WorkContext<T> execute(String flowName, WorkContext<T> context) {
        this.checkInputFlowData(flowName, context);
        this.executeFlow(flowName, context);
        return context;
    }


    private void checkInputFlowData(String flowName, WorkContext context) {
        if (context == null) {
            throw new IllegalStateException("流程" + flowName + "入参context不能为空");
        }
    }


    private void executeFlow(String flowName, WorkContext context) {
        try {
            AbstractWorkFlow abstractWorkFlow = WorkFlowHub.get(flowName);
            abstractWorkFlow.execute(context);
        } catch (Throwable e) {
            ExceptionUtil.rethrow(e);
        }

    }


}
