package com.smartgeek.component.flow;

import com.smartgeek.component.flow.engine.SmartFlowEngine;
import com.smartgeek.component.flow.flow.FlowsHub;
import com.smartgeek.component.flow.processor.NodeProcessorHub;
import com.smartgeek.component.flow.transaction.FlowTxsHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author cys
 * @date 2022/9/21 15:50
 * @description:
 */
@Configuration
@Import({FlowsHub.class, NodeProcessorHub.class, FlowTxsHolder.class})
public class SmartFlowEngineConfiguration {
    @Autowired
    private FlowsHub flowsHub;
    @Bean
    public FlowEngine flowEngine() {
        return new SmartFlowEngine(this.flowsHub);
    }
}
