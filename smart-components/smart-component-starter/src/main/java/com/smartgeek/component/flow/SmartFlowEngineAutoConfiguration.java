package com.smartgeek.component.flow;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author cys
 * @date 2022/9/21 15:49
 * @description:
 */
@Configuration
@Import({SmartFlowEngineConfiguration.class})
//@EnableConfigurationProperties({HaloProperties.class})
public class SmartFlowEngineAutoConfiguration {

    public SmartFlowEngineAutoConfiguration() {
    }


}
