package com.smartgeek.component.flow.flow;


import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.json.JSONUtil;
import com.smartgeek.component.flow.engine.FlowHandleContext;
import com.smartgeek.component.flow.exception.FlowExecutionException;
import com.smartgeek.component.flow.persistence.FlowCommonResourceHolder;
import com.smartgeek.component.flow.persistence.FlowExeRecord;
import com.smartgeek.component.flow.transaction.FlowTxExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * 流执行人
 *
 * @author cys
 * @date 2022/9/21 13:14
 * @description:
 */
public class FlowExecutor {

    private static final Logger log = LoggerFactory.getLogger(FlowExecutor.class);
    private String flowName;
    private boolean enableFlowTx;
    private Object flow;
    private String startNode;
    private Set<String> endNodes = new HashSet();
    private Map<String, NodeExecutor> nodeExecutorMap = new ConcurrentHashMap();
    private FlowTxExecutor flowTxExecutor;
    private Class classOfTarget;


    public FlowExecutor(String flowName, boolean enableFlowTx, Object flow) {
        this.flowName = flowName;
        this.enableFlowTx = enableFlowTx;
        this.flow = flow;
    }


    public void execute(FlowHandleContext flowHandleContext) throws Throwable {
        this.execute(flowHandleContext, this.startNode);
    }


    public void execute(FlowHandleContext flowHandleContext, String nodeName) throws Throwable {

        String node = nodeName;
        NodeExecutor nodeExecutor = null;
        log.info("[flow-engine] start to execute flow, flow={}, node={}，context={}", new Object[]{this.flowName, nodeName, flowHandleContext});

        try {
            if (!this.endNodes.contains(node)) {
                this.beforeFlow(flowHandleContext);
                while(true) {
                    log.info("[flow-engine] start to execute flow node, flow={}, node={}，context={}", new Object[]{this.flowName, node, flowHandleContext});
                    if (!this.nodeExecutorMap.containsKey(node)) {
                        throw new RuntimeException("流程" + this.flowName + "不存在节点" + node);
                    }

                    nodeExecutor = this.nodeExecutorMap.get(node);
                    if (!nodeExecutor.isAutoExecute()) {
                        break;
                    }

                    this.beforeNode(nodeExecutor);
                    String nextNode = nodeExecutor.execute(this.flow, flowHandleContext);
                    this.afterNode(nodeExecutor);
                    log.info("[flow-engine] execute flow node success, flow={}, node={}，context={}", new Object[]{this.flowName, node, flowHandleContext});
                    if (nextNode == null) {
                        break;
                    }

                    node = nextNode;
                }

                this.afterFlow(flowHandleContext);
                log.info("[flow-engine] execute flow success, flow={}, context={}", this.flowName, flowHandleContext);
            }
        } catch (Throwable e) {
            this.afterThrowing(e, flowHandleContext, nodeName, nodeExecutor);
            e.addSuppressed(new FlowExecutionException(this.flowName, nodeName, flowHandleContext));
            throw e;
        }


    }




    private void beforeFlow(FlowHandleContext flowHandleContext) {
        if (this.enableFlowTx) {
            this.flowTxExecutor.createTx();
        }

    }


    private void afterFlow(FlowHandleContext flowHandleContext) {
        if (this.enableFlowTx && this.flowTxExecutor.hasTx()) {
            this.flowTxExecutor.commitTx();
        }

    }


    private void beforeNode(NodeExecutor nodeExecutor) {
        if (this.enableFlowTx && nodeExecutor.isEnableNodeTx()) {
            if (this.flowTxExecutor.hasTx()) {
                this.flowTxExecutor.commitTx();
            }

            this.flowTxExecutor.createTx();
        }

    }

    private void afterNode(NodeExecutor nodeExecutor) {
        if (this.enableFlowTx && nodeExecutor.isEnableNodeTx()) {
            this.flowTxExecutor.commitTx();
        }

        if (this.enableFlowTx && !this.flowTxExecutor.hasTx()) {
            this.flowTxExecutor.createTx();
        }

    }


    private void recordFailedFlowNode(String currNode, NodeExecutor currNodeExecutor, FlowHandleContext flowHandleContext) {
        if (this.enableFlowTx && currNode != null && currNodeExecutor != null) {
            if (FlowCommonResourceHolder.isFlowRepositoryEnabled() && currNodeExecutor.isEnableNodeTx()) {
                FlowExeRecord record = new FlowExeRecord();
                record.setFlowId(this.flow.getClass().getName());
                record.setFlowName(this.flowName);
                record.setNodeName(currNode);
                record.setAppId(SpringUtil.getApplicationContext().getEnvironment().getProperty("spring.application.name", ""));
                record.setContext(flowHandleContext);
                FlowCommonResourceHolder.getFlowRepository().asynAddFailedRecord(record);
            }

        }
    }


    private void afterThrowing(Throwable throwable, FlowHandleContext flowHandleContext, String currNode, NodeExecutor currNodeExecutor) {
        try {
            log.error(String.format("[flow-engine] execute flow failed, flow=%s, currNode=%s, context=%s", this.flowName, currNode, JSONUtil.toJsonStr(flowHandleContext)), throwable);
            if (this.enableFlowTx && this.flowTxExecutor.hasTx()) {
                this.flowTxExecutor.rollbackTx();
            }
        } finally {
            this.recordFailedFlowNode(currNode, currNodeExecutor, flowHandleContext);
        }

    }


    public void addNode(NodeExecutor nodeExecutor) {
        if (this.nodeExecutorMap.containsKey(nodeExecutor.getNodeName())) {
            throw new IllegalStateException("流程" + this.flowName + "存在同名的节点" + nodeExecutor.getNodeName());
        } else {
            this.nodeExecutorMap.put(nodeExecutor.getNodeName(), nodeExecutor);
        }
    }

    public boolean containsNode(String nodeName) {
        return this.nodeExecutorMap.containsKey(nodeName);
    }

    public void setStartNode(String startNode) {
        if (this.startNode != null) {
            throw new IllegalStateException("流程" + this.flowName + "存在多个开始节点");
        } else {
            this.startNode = startNode;
        }
    }

    public void addEndNode(String endNode) {
        this.endNodes.add(endNode);
    }

    public void setFlowTxExecutor(FlowTxExecutor flowTxExecutor) {
        if (!this.enableFlowTx) {
            throw new IllegalStateException("流程" + this.flowName + "的enableFlowTx属性为关闭状态，不能设置流程事务");
        } else if (this.flowTxExecutor != null) {
            throw new IllegalStateException("流程" + this.flowName + "的流程事务执行器已被设置，不能重复设置");
        } else {
            this.flowTxExecutor = flowTxExecutor;
        }
    }

    public String getFlowName() {
        return this.flowName;
    }

    public Object getFlow() {
        return this.flow;
    }

    public Class getClassOfTarget() {
        return this.classOfTarget;
    }

    public void setClassOfTarget(Class classOfTarget) {
        this.classOfTarget = classOfTarget;
    }

    public void validate() {
        if (this.flowName != null && this.flow != null) {
            if (this.startNode == null) {
                throw new IllegalStateException("流程" + this.flowName + "缺少开始节点");
            } else if (this.endNodes.isEmpty()) {
                throw new IllegalStateException("流程" + this.flowName + "没有结束节点");
            } else {
                if (this.enableFlowTx) {
                    if (this.flowTxExecutor == null) {
                        throw new IllegalStateException("流程" + this.flowName + "的enableFlowTx属性为开启状态，但未设置对应的流程事务");
                    }
                } else if (this.flowTxExecutor != null) {
                    throw new IllegalStateException("流程" + this.flowName + "的enableFlowTx属性为关闭状态，但设置了流程事务");
                }

                Set<Class> processorTargetClasses = this.nodeExecutorMap.values().stream().map(NodeExecutor::getClassOfTargetOfProcessor).filter(Objects::nonNull).collect(Collectors.toSet());
                if (processorTargetClasses.size() > 1) {
                    throw new IllegalStateException("流程" + this.flowName + "内节点的处理器的目标对象类型不统一");
                } else {
                    this.classOfTarget = processorTargetClasses.size() > 0 ? (Class) processorTargetClasses.iterator().next() : null;
                }
            }
        } else {
            throw new IllegalStateException("流程" + this.flowName + "内部要素不全");
        }
    }
}
