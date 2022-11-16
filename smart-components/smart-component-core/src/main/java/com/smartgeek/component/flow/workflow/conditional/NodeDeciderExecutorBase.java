package com.smartgeek.component.flow.workflow.conditional;

import com.smartgeek.component.flow.work.WorkContext;

import java.lang.reflect.Method;

/**
 * @author cys
 * @date 2022/9/21 14:06
 * @description:
 */
public class NodeDeciderExecutorBase extends BaseMethodExecutor {

    private ParametersType parametersType;
    private Class classOfTarget;

    public NodeDeciderExecutorBase(Method targetMethod, ParametersType parametersType, Class classOfTarget) {
        super(targetMethod);
        this.parametersType = parametersType;
        this.classOfTarget = classOfTarget;
    }

    public String execute(Object flow, Object processResult, WorkContext flowHandleContext) throws Throwable {
        switch (this.parametersType) {
            case NONE:
                return (String) this.execute(flow, new Object[0]);
            case ONLY_PROCESS_RESULT:
                return (String) this.execute(flow, new Object[]{processResult});
            case ONLY_TARGET_CONTEXT:
                return (String) this.execute(flow, new Object[]{flowHandleContext});
            case PROCESS_RESULT_AND_TARGET_CONTEXT:
                return (String) this.execute(flow, new Object[]{processResult, flowHandleContext});
            default:
                throw new IllegalStateException("下个节点选择方法执行器内部状态不对");
        }
    }

    public Class getClassOfTarget() {
        return this.classOfTarget;
    }

}
