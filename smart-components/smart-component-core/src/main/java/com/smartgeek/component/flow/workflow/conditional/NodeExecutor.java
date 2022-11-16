package com.smartgeek.component.flow.workflow.conditional;

import com.smartgeek.component.flow.work.WorkContext;
import lombok.AllArgsConstructor;

/**
 * @author cys
 * @date 2022/11/16 14:05
 * @description:
 */
@AllArgsConstructor
public class NodeExecutor {

    private String nodeName;
    private ProcessorExecutor processorExecutor;
    /**
     * 自动执行
     */
    private boolean autoExecute;
    private boolean enableNodeTx;
    private NodeDeciderExecutorBase nodeDeciderExecutor;

    public NodeExecutor(String nodeName, ProcessorExecutor processorExecutor, boolean autoExecute, boolean enableNodeTx) {
        this.nodeName = nodeName;
        this.processorExecutor = processorExecutor;
        this.autoExecute = autoExecute;
        this.enableNodeTx = enableNodeTx;
    }

    public String execute(Object flow, WorkContext flowHandleContext) throws Throwable {
        Object processResult = null;
        if (null != this.processorExecutor) {
//            processResult = this.processorExecutor.execute(flowHandleContext);
            this.processorExecutor.execute(flowHandleContext);
        }

        return this.nodeDeciderExecutor.execute(flow, processResult, flowHandleContext);
    }

    public void setNodeDeciderExecutor(NodeDeciderExecutorBase nodeDeciderExecutor) {
        if (this.nodeDeciderExecutor != null) {
            throw new IllegalStateException("节点" + this.nodeName + "已设置节点决策器执行器，不能重复设置");
        } else {
            this.nodeDeciderExecutor = nodeDeciderExecutor;
        }
    }

    public boolean isAutoExecute() {
        return this.autoExecute;
    }

    public boolean isEnableNodeTx() {
        return this.enableNodeTx;
    }

    public String getNodeName() {
        return this.nodeName;
    }

    public Class getClassOfTargetOfProcessor() {
        return this.processorExecutor != null ? this.processorExecutor.getClassOfTarget() : null;
    }

    public Class getClassOfTargetOfNodeDecider() {
        return this.nodeDeciderExecutor.getClassOfTarget();
    }

    public void validate() {
        if (this.nodeName == null || this.nodeDeciderExecutor == null) {
            throw new IllegalStateException("节点" + this.nodeName + "内部要素不全");
        }
    }
    
}
