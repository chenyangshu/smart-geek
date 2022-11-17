package com.smartgeek.component.flow.workflow.rule;

import com.smartgeek.component.flow.engine.WorkContext;
import com.smartgeek.component.flow.workflow.AbstractWorkFlow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cys
 * @date 2022/11/17 15:33
 * @description:
 */
public class RuleFlow extends AbstractWorkFlow {


    private static final Logger log = LoggerFactory.getLogger(RuleFlowExecutor.class);

    private RuleFlowExecutor ruleFlowExecutor;

    public RuleFlow( RuleFlowExecutor ruleFlowExecutor) {
        super(ruleFlowExecutor.getName());
        this.ruleFlowExecutor = ruleFlowExecutor;
    }

    @Override
    public void execute(WorkContext context) {
        ruleFlowExecutor.execute(context);
    }
}
