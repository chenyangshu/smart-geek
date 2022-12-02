package com.smartgeek.component.flow.transaction;

import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author cys
 * @date 2022/9/21 12:48
 * @description:
 */
public class FlowTxParser {

    public FlowTxParser() {
    }

    public static FlowTxExecutor parseFlowTx(String flow, PlatformTransactionManager transactionManager) {
        FlowTxExecutor flowTxExecutor = new FlowTxExecutor(flow, transactionManager);
        flowTxExecutor.validate();
        return flowTxExecutor;
    }
}
