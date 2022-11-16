package com.smartgeek.component.flow.workflow;

import com.smartgeek.component.flow.work.WorkContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cys
 * @date 2022/11/15 11:11
 * @description:
 */
public abstract class AbstractWorkFlow implements WorkFlow {
    private static final Logger log = LoggerFactory.getLogger(AbstractWorkFlow.class);
    protected String name;
    protected Boolean enableFlowTx=true;
    protected String txManager="";


    public AbstractWorkFlow(String name) {
        this.name = name;
    }

    public abstract void execute(WorkContext context);


    public String getName() {
        return this.name;
    }


    public Boolean getEnableFlowTx() {
        return enableFlowTx;
    }

    public String getTxManager() {
        return txManager;
    }

    public void setEnableFlowTx(Boolean enableFlowTx) {
        this.enableFlowTx = enableFlowTx;
    }

    public void setTxManager(String txManager) {
        this.txManager = txManager;
    }
}
