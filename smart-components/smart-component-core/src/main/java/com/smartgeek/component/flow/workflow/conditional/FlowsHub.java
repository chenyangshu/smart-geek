package com.smartgeek.component.flow.workflow.conditional;

import com.smartgeek.component.flow.annotation.flow.Flow;
import com.smartgeek.component.flow.registrar.FlowRegistrar;
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
public class FlowsHub {
    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private NodeProcessorHub nodeProcessorHub;

    @Autowired
    private WorkFlowTxsHolder flowTxsHolder;


    @Autowired
    private FlowRegistrar flowRegistrar;


    public FlowsHub() {
    }

    @PostConstruct
    public void init() {
        String[] flowBeanNames = this.applicationContext.getBeanNamesForAnnotation(Flow.class);
        for (String flowBeanName : flowBeanNames) {
            FlowExecutor flowExecutor = FlowParser.parseFlow(this.applicationContext.getBean(flowBeanName), this.nodeProcessorHub, this.flowTxsHolder);
            if (this.flowRegistrar.containsKey(flowExecutor.getName())) {
                throw new RuntimeException("存在重名的流程" + flowExecutor.getName());
            }
            this.flowRegistrar.register(flowExecutor);
        }

    }

}
