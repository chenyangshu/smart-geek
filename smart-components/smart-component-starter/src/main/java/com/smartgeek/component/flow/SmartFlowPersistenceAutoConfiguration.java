package com.smartgeek.component.flow;

import com.smartgeek.component.flow.persistence.FlowPersistenceProperties;
import com.smartgeek.component.flow.persistence.FlowRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;

/**
 * @author cys
 * @date 2022/9/21 15:50
 * @description:
 */

@Configuration
public class SmartFlowPersistenceAutoConfiguration implements ApplicationContextAware {

    private static final Log logger = LogFactory.getLog(SmartFlowPersistenceAutoConfiguration.class);

    private ApplicationContext applicationContext;

    public SmartFlowPersistenceAutoConfiguration() {
    }

    @ConditionalOnMissingBean
    @ConfigurationProperties(prefix = "flow.engine")
    public FlowPersistenceProperties flowPersistenceProperties() {
        return new FlowPersistenceProperties();
    }


    @ConditionalOnMissingBean
    public FlowRepository flowRepository(FlowPersistenceProperties properties) {
        return new DummyFlowRepository( properties);
    }



    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }




}
