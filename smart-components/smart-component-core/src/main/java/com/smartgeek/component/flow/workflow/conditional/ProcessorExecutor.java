package com.smartgeek.component.flow.workflow.conditional;


import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.work.WorkContext;

import java.lang.reflect.Method;

/**
 * 处理器执行程序
 *
 * @author treeyschen
 * @date 2022/09/21
 */
public class ProcessorExecutor {

    /**
     * 处理器名字
     */
    private String processorName;
    /**
     * 处理器
     */
    private Work processor;


    /**
     * 处理器方法执行程序
     */
    private ProcessorBaseMethodExecutor processorMethodExecutor;

    /**
     * 处理器执行程序
     *
     * @param processorName 处理器名字
     * @param processor     处理器
     */
    public ProcessorExecutor(String processorName, Work processor) {
        this.processorName = processorName;
        this.processor = processor;
    }


    /**
     * 执行
     *
     * @param flowHandleContext 流处理上下文
     * @return {@link Object}
     * @throws Throwable throwable
     */
    public void execute(WorkContext flowHandleContext) throws Throwable {
        this.processor.execute(flowHandleContext);
    }


    public Class getReturnType() {
        return this.processorMethodExecutor.getReturnType();
    }

    public void setMethodExecutor(ProcessorBaseMethodExecutor methodExecutor) {
        this.processorMethodExecutor = methodExecutor;
    }

    public Class getClassOfTarget() {
        return this.processorMethodExecutor.getClassOfTarget();
    }

    public String getProcessorName() {
        return this.processorName;
    }

    public Object getProcessor() {
        return this.processor;
    }

    /**
     * 验证
     */
    public void validate() {
        if (this.processorName != null && this.processor != null) {
            if (this.processorMethodExecutor == null) {
                throw new IllegalStateException("处理器" + this.processorName + "不存处理器方法");
            }
        } else {
            throw new IllegalStateException("处理器" + this.processorName + "内部要素不全");
        }
    }

    /**
     * 处理器基本方法执行程序
     *
     * @author treeyschen
     * @date 2022/09/21
     */
    public static class ProcessorBaseMethodExecutor extends BaseMethodExecutor {
        private Class classOfTarget;

        public ProcessorBaseMethodExecutor(Method targetMethod, Class classOfTarget) {
            super(targetMethod);
            this.classOfTarget = classOfTarget;
        }

        public Object execute(Object processor, WorkContext flowHandleContext) throws Throwable {
            return this.execute(processor, new Object[]{flowHandleContext});
        }

        public Class getClassOfTarget() {
            return this.classOfTarget;
        }
    }

}
