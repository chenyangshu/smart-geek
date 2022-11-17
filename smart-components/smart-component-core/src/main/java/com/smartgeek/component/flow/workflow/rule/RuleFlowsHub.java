package com.smartgeek.component.flow.workflow.rule;

import com.smartgeek.component.flow.annotation.flow.Flow;
import com.smartgeek.component.flow.processor.NodeProcessorHub;
import com.smartgeek.component.flow.workflow.WorkFlowHub;
import com.smartgeek.component.flow.transaction.WorkFlowTxsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author cys
 * @date 2022/9/21 10:56
 * @description:
 */

@Component
public class RuleFlowsHub {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private NodeProcessorHub nodeProcessorHub;

    @Autowired
    private WorkFlowTxsHolder flowTxsHolder;

    public RuleFlowsHub() {
    }

    @PostConstruct
    public void init() {
        String[] flowBeanNames = this.applicationContext.getBeanNamesForAnnotation(Flow.class);
        for (String flowBeanName : flowBeanNames) {
            RuleFlowExecutor ruleFlowExecutor = RuleFlowParser.parseFlow(this.applicationContext.getBean(flowBeanName), this.nodeProcessorHub, this.flowTxsHolder);
            RuleFlow ruleFlow = new RuleFlow(ruleFlowExecutor);
//            if (WorkFlowHub.containsKey(ruleFlowExecutor.getName())) {
//                throw new RuntimeException("存在重名的流程" + ruleFlowExecutor.getName());
//            }
            WorkFlowHub.register(ruleFlow);
        }

    }

}
