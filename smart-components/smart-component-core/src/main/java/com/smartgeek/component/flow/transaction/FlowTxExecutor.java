package com.smartgeek.component.flow.transaction;

import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author cys
 * @date 2022/9/21 12:48
 * @description:
 */
public class FlowTxExecutor extends TxExecutor {

    private String flow;

    public FlowTxExecutor(String flow, PlatformTransactionManager transactionManager) {
        super(transactionManager);
        this.flow = flow;
    }

    public String getFlow() {
        return this.flow;
    }
}
