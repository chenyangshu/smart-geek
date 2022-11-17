package com.smartgeek.component.flow.workflow.sequential;

import cn.hutool.extra.spring.SpringUtil;
import com.smartgeek.component.flow.work.Work;
import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.exception.FlowExecutionException;
import com.smartgeek.component.flow.transaction.FlowTxExecutor;
import com.smartgeek.component.flow.transaction.WorkFlowTxsHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author cys
 * @date 2022/11/15 14:58
 * @description:
 */
public class SequentialFlowExecutor {
    private static final Logger log = LoggerFactory.getLogger(SequentialFlowExecutor.class);
    private boolean enableFlowTx;
    private String flowName;

    private List<Class<? extends Work>> enableTxWorks;


    public SequentialFlowExecutor(boolean enableFlowTx, String flowName, List<Class<? extends Work>> enableTxWorks) {
        this.enableFlowTx = enableFlowTx;
        this.flowName = flowName;
        this.enableTxWorks = enableTxWorks;
    }


    void execute(List<Work> workUnits, WorkContext workContext) {
        WorkFlowTxsHolder flowTxsHolder = SpringUtil.getBean(WorkFlowTxsHolder.class);
        FlowTxExecutor flowTxExecutor = flowTxsHolder.getRequiredFlowTxExecutor(flowName);
        this.beforeFlow(flowTxExecutor);
        for (Work work : workUnits) {
            try {
                this.beforeWork(work, flowTxExecutor);
                work.execute(workContext);
                this.afterWork(work, flowTxExecutor);
            } catch (Throwable e) {
                this.afterThrowing(e, workContext, work, flowTxExecutor);
                e.addSuppressed(new FlowExecutionException(this.flowName, work.getName(), workContext));
                throw e;
            }
        }
        this.afterFlow(flowTxExecutor);
    }

    private void beforeFlow(FlowTxExecutor flowTxExecutor) {
        if (this.enableFlowTx) {
            flowTxExecutor.createTx();
        }
    }

    private void afterFlow(FlowTxExecutor flowTxExecutor) {
        if (this.enableFlowTx && flowTxExecutor.hasTx()) {
            flowTxExecutor.commitTx();
        }
    }


    private void beforeWork(Work work, FlowTxExecutor flowTxExecutor) {
        if (this.enableFlowTx && isEnableWorkTx(work)) {
            if (flowTxExecutor.hasTx()) {
                flowTxExecutor.commitTx();
            }

            flowTxExecutor.createTx();
        }
    }

    private void afterWork(Work work, FlowTxExecutor flowTxExecutor) {
        if (this.enableFlowTx && isEnableWorkTx(work)) {
            flowTxExecutor.commitTx();
        }

        if (this.enableFlowTx && !flowTxExecutor.hasTx()) {
            flowTxExecutor.createTx();
        }
    }

    private void afterThrowing(Throwable throwable, WorkContext workContext, Work work, FlowTxExecutor flowTxExecutor) {
        try {
            log.error(String.format("[flow-engine] execute flow failed, flow=%s, currNode=%s, context=%s", this.flowName, work.getName(), workContext), throwable);
            if (this.enableFlowTx && flowTxExecutor.hasTx()) {
                flowTxExecutor.rollbackTx();
            }
        } finally {
            this.recordFailedFlowNode(throwable, workContext, this.flowName, work);
        }
    }

    private void recordFailedFlowNode(Throwable throwable, WorkContext workContext, String flowName, Work work) {

    }


    private boolean isEnableWorkTx(Work work) {
        return enableTxWorks.contains(work.getClass());
    }


}
