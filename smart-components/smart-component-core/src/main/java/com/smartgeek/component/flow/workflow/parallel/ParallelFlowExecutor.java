package com.smartgeek.component.flow.workflow.parallel;

import cn.hutool.extra.spring.SpringUtil;
import com.smartgeek.component.flow.work.*;
import com.smartgeek.component.flow.transaction.FlowTxExecutor;
import com.smartgeek.component.flow.transaction.WorkFlowTxsHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * @author cys
 * @date 2022/11/15 14:49
 * @description:
 */
public class ParallelFlowExecutor {
    private static final Logger log = LoggerFactory.getLogger(ParallelFlowExecutor.class);
    private String flowName;
    private boolean enableFlowTx;
    private final ExecutorService workExecutor;


    public ParallelFlowExecutor(String flowName, boolean enableFlowTx, ExecutorService workExecutor) {
        this.flowName = flowName;
        this.enableFlowTx = enableFlowTx;
        this.workExecutor = workExecutor;
    }

    public void execute(List<Work> workUnits, WorkContext workContext) {
        WorkFlowTxsHolder flowTxsHolder = SpringUtil.getBean(WorkFlowTxsHolder.class);
        FlowTxExecutor flowTxExecutor = flowTxsHolder.getRequiredFlowTxExecutor(flowName);
        this.beforeFlow(flowTxExecutor);
        try {
            List<WorkReport> workReports = this.executeInParallel(workUnits, workContext);

            for (WorkReport workReport : workReports) {
                if (WorkStatus.FAILED.equals(workReport.getStatus())) {
                    throw new RuntimeException(workReport.getError());
                }
            }
        } catch (Throwable e) {
            this.afterThrowing(e, workContext, flowTxExecutor);
            throw e;
        }
        this.afterFlow(flowTxExecutor);
    }

    private void afterThrowing(Throwable throwable, WorkContext workContext, FlowTxExecutor flowTxExecutor) {

        try {
            log.error(String.format("[flow-engine] execute flow failed, flow=%s, context=%s", this.flowName, workContext), throwable);
            if (this.enableFlowTx && flowTxExecutor.hasTx()) {
                flowTxExecutor.rollbackTx();
            }
        } finally {
            this.recordFailedFlowNode(throwable, workContext, this.flowName);
        }

    }

    private void recordFailedFlowNode(Throwable throwable, WorkContext workContext, String flowName) {

    }


    private List<WorkReport> executeInParallel(List<Work> workUnits, WorkContext workContext) {
        // prepare tasks for parallel submission
        List<Callable<WorkReport>> tasks = new ArrayList<>(workUnits.size());
        workUnits.forEach(work -> tasks.add(() -> {
            try {
                work.execute(workContext);
                return new DefaultWorkReport(WorkStatus.COMPLETED, workContext);
            } catch (Throwable throwable) {
                return new DefaultWorkReport(WorkStatus.FAILED, workContext, throwable);
            }
        }));

        // submit work units and wait for results
        List<Future<WorkReport>> futures;
        try {
            futures = this.workExecutor.invokeAll(tasks);
        } catch (InterruptedException e) {
            throw new RuntimeException("The parallel flow was interrupted while executing work units", e);
        }
        Map<Work, Future<WorkReport>> workToReportFuturesMap = new HashMap<>();
        for (int index = 0; index < workUnits.size(); index++) {
            workToReportFuturesMap.put(workUnits.get(index), futures.get(index));
        }

        // gather reports
        List<WorkReport> workReports = new ArrayList<>();
        for (Map.Entry<Work, Future<WorkReport>> entry : workToReportFuturesMap.entrySet()) {
            try {
                workReports.add(entry.getValue().get());
            } catch (InterruptedException e) {
                String message = String.format("The parallel flow was interrupted while waiting for the result of work unit '%s'", entry.getKey().getName());
                throw new RuntimeException(message, e);
            } catch (ExecutionException e) {
                String message = String.format("Unable to execute work unit '%s'", entry.getKey().getName());
                throw new RuntimeException(message, e);
            }
        }

        return workReports;
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

}
