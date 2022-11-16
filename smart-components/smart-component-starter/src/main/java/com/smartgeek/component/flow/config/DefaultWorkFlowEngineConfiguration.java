package com.smartgeek.component.flow.config;

import com.smartgeek.component.flow.engine.DefaultWorkFlowEngine;
import com.smartgeek.component.flow.engine.WorkFlowEngine;
import com.smartgeek.component.flow.registrar.FlowRegistrar;

import com.smartgeek.component.flow.transaction.WorkFlowTxsHolder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author cys
 * @date 2022/9/21 15:50
 * @description:
 */
@Configuration
@Import({FlowRegistrar.class, WorkFlowTxsHolder.class})
public class DefaultWorkFlowEngineConfiguration {

    @Bean
    public WorkFlowEngine workFlowEngine(FlowRegistrar flowRegistrar) {
        return new DefaultWorkFlowEngine(flowRegistrar);
    }
}
